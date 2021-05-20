package bmstu.configuration

import bmstu.algorithm.service.CrossFunctions
import bmstu.algorithm.service.Generation
import bmstu.algorithm.service.RoutesBuilder
import bmstu.algorithm.service.RoutesFunctions
import bmstu.algorithm.service.crossRoutes
import bmstu.configuration.Constraint.Companion.ALL_GENERATIONS
import bmstu.configuration.Constraint.Companion.POPULATION_CAPACITY
import bmstu.configuration.Constraint.Companion.START_GENERATION_CAPACITY
import bmstu.support.CoordinatesWriterJson
import bmstu.support.FileSupport
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class AppConfig(
    private val routesBuilder: RoutesBuilder,
    private val writerJson: CoordinatesWriterJson,
    private val population: Generation,
    private val routesFunctions: RoutesFunctions,
    private val crossFunctions: CrossFunctions
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        startApplication()
    }

    private fun startApplication() {
        createStartGeneration()
        population.commonRating()
        (0..20).onEach {
            population.selection()
            population.getTopPopulation()
            if (it % 2 == 0 || it == 0) crossRoutesInnerPopulation()
            population.selection()
            population.getTopPopulation()
            if (it % 5 == 0 && it != 0) crossPopulations()
            population.commonRating()
            crossRoutesExternalPopulation()
            population.selection()
            population.getTopPopulation()
            population.commonRating()
        }
        writeReport()
    }

    /**
     * Функция фасад, которая запускает все функции связанные со стартовым наполнением популяции
     * зависит от двух констант 1) START_GENERATION_CAPACITY - Стартовое наполнение поколения
     *                          2) POPULATION_CAPACITY - Количество маршрутов в одной популяции
     */
    private fun createStartGeneration() {
        (0 until START_GENERATION_CAPACITY).onEach {
            ALL_GENERATIONS.add (population.createPopulation(POPULATION_CAPACITY))
        }
    }

    /**
     * Функция скрещивает маршруты внутри одной популяции (Коллекции маршрутов)
     * добавляет получившийся маршрут в ту популяцию, в которой происходило скрещивание,
     * после того как произошло скрещивание, выполняется отбор в рамках одной популяции,
     * а также происходит проверка и наполнение (в случае если этой первый цикл) 3-х лучших маршрутов
     */
    private fun crossRoutesInnerPopulation() {
        ALL_GENERATIONS.forEach { population ->
            (0 until population.size).onEach {
                val crossRoute = if (it + 1 < population.size) {
                    crossRoutes(population[it], population[it + 1])
                } else crossRoutes(population[it], population[0])
                crossRoute?.let { resultRoute ->
                    population.add(resultRoute)
                }
            }
            routesFunctions.selected(population)
            routesFunctions.fillTopRoutes(population)
        }
    }

    /**
     * Функция скрещивает маршруты в скопе одного поколения
     * выбор 2-х популяций, в которых будет производится скрещивание происходит случайным образом
     * функция похожа на crossRoutesInnerPopulation(), разница в скопе скрещивания
     * хардкод, лучше не лезть
     */
    private fun crossRoutesExternalPopulation() {
        val random = Random()
        val randomPopulation1 = random.nextInt(ALL_GENERATIONS.size)
        val randomPopulation2 = random.nextInt(ALL_GENERATIONS.size)
            .run {
                if (this == randomPopulation1) {
                    var randomPopulationNumber = random.nextInt(ALL_GENERATIONS.size)
                    while (randomPopulationNumber == randomPopulation1) randomPopulationNumber = random.nextInt(ALL_GENERATIONS.size)
                    randomPopulationNumber
                } else this
            }
        val population1 = ALL_GENERATIONS[randomPopulation1]
        val population2 = ALL_GENERATIONS[randomPopulation2]

        (0 until population1.size).onEach {
            if (it < population1.size && it < population2.size) {
                val crossRoute = if (it + 1 < population2.size) crossRoutes(population1[it], population2[it + 1])
                else crossRoutes(population1[it], population2[0])
                crossRoute?.let { route ->
                    population1.add(route)
                }
            }
            routesFunctions.selected(population1)
            routesFunctions.fillTopRoutes(population1)
        }

    }

    /**
     * Функция проходит по поколению и делает скрещивание популяций, добавляет получившуюся популяцию в поколение
     * делает отбор и делает чек лучших популяций
     */
    private fun crossPopulations() {
        (0 until ALL_GENERATIONS.size).onEach {
            val crossPopulation = if (it + 1 < ALL_GENERATIONS.size) crossFunctions.crossGenerations(ALL_GENERATIONS[it], ALL_GENERATIONS[it + 1])
            else crossFunctions.crossGenerations(ALL_GENERATIONS[it], ALL_GENERATIONS[0])
            ALL_GENERATIONS.add(crossPopulation)
        }
    }

    private fun writeReport() {
        FileSupport.writeTopGenerations()
        FileSupport.writeTopRoutes()
        FileSupport.writeMinMaxDistance()
        FileSupport.writeAllGenRating()
    }
}