package bmstu.configuration


import bmstu.algorithm.dto.BusStopWithWeight
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
    private val generation: Generation,
    private val routesFunctions: RoutesFunctions,
    private val crossFunctions: CrossFunctions
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        startApplication()
    }

    private fun startApplication() {
        createStartGeneration()
        generation.getTopGeneration()
        crossRoutesInnerPopulation()
        generation.getTopGeneration()
        FileSupport.writeTopGenerations()
        FileSupport.writeTopRoutes()
    }

    /**
     * Функция фасад, которая запускает все функции связанные со стартовым наполнением популяции
     * зависит от двух констант 1) START_GENERATION_CAPACITY - Стартовое наполнение поколения
     *                          2) POPULATION_CAPACITY - Количество маршрутов в одной популяции
     */
    private fun createStartGeneration() {
        (0 until START_GENERATION_CAPACITY).onEach {
            ALL_GENERATIONS.add (generation.createGeneration(POPULATION_CAPACITY))
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
}