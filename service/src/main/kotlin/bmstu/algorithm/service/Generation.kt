package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeightDto
import bmstu.configuration.Constraint.Companion.ALL_GENERATIONS
import bmstu.configuration.Constraint.Companion.SELECTED_POPULATION
import bmstu.configuration.Constraint.Companion.TOP_3_POPULATION
import bmstu.support.FileSupport
import org.springframework.stereotype.Service
import java.util.LinkedList

@Service
class Generation(
    private val routesBuilder: RoutesBuilder
) {

    fun commonRating(): Float {
        var commonRating = 0.0F
        var count = 0
        ALL_GENERATIONS.forEach {
            count++
            commonRating += populationRating(it)
        }
        commonRating /= count
        FileSupport.ALL_GENERATIONS_RATING.append("COMMON RATING $commonRating\n")
        return commonRating
    }

    /**
     * Функция отбирает N популяций методом турнирного отбора
     * N - задается в Constant
     */
    fun selection() {
        ALL_GENERATIONS.sortBy { populationRating(it) }
        if (ALL_GENERATIONS.size != SELECTED_POPULATION)
            (0 until ALL_GENERATIONS.size - SELECTED_POPULATION).onEach {
                ALL_GENERATIONS.removeFirst()
            }
    }

    fun createPopulation(capacity: Int): MutableList<LinkedList<BusStopWithWeightDto>> {

        val randomBusStops = routesBuilder.getRandomBusStops()
        val generation = mutableListOf(LinkedList<BusStopWithWeightDto>())
        (0 until capacity).onEach {
            generation.add(
                routesBuilder.createRoute(
                    randomBusStops.first(),
                    randomBusStops.last(),
                    randomBusStops
                )
            )
        }
        generation.removeFirst()
        return generation
    }

    fun getTopPopulation() {
        ALL_GENERATIONS.sortBy { populationRating(it) }
        ALL_GENERATIONS.takeLast(3).forEach {
            TOP_3_POPULATION[it] = populationRating(it)
        }
        TOP_3_POPULATION.values.forEach {
            FileSupport.TOP_GENERATIONS_BUFFER.append("\n RATING = $it")
        }
        FileSupport.TOP_GENERATIONS_BUFFER.append("\n")
        TOP_3_POPULATION.clear()
    }

    fun populationRating(generation: MutableList<LinkedList<BusStopWithWeightDto>>): Float {
        var rating = 0.0F
        generation.forEach {
            rating += routesBuilder.routeRating(it)
        }
        return rating / generation.size.toFloat()
    }
}
