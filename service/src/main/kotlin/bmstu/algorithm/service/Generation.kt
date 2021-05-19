package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import bmstu.configuration.Constraint.Companion.ALL_GENERATIONS
import bmstu.configuration.Constraint.Companion.SELECTED_POPULATION
import bmstu.configuration.Constraint.Companion.TOP_3_GENERATIONS
import bmstu.support.FileSupport
import org.springframework.stereotype.Service
import java.util.*

@Service
class Generation(
    private val routesBuilder: RoutesBuilder
) {

    /**
     * Функция отбирает N популяций методом турнирного отбора
     * N - задается в Constant
     */
    fun selection() {
        ALL_GENERATIONS.sortBy { generationRating(it) }
        while (ALL_GENERATIONS.size != SELECTED_POPULATION) ALL_GENERATIONS.removeFirst()
    }

    fun createGeneration(capacity: Int): MutableList<LinkedList<BusStopWithWeight>> {

        val randomBusStops = routesBuilder.getRandomBusStops()
        val generation = mutableListOf(LinkedList<BusStopWithWeight>())
        (0 until capacity).onEach {
            generation.add(routesBuilder.createRandomRoute(
                randomBusStops.first(),
                randomBusStops.last(),
                randomBusStops
            ))
        }
        generation.removeFirst()
        return generation
    }

    fun getTopGeneration() {
        ALL_GENERATIONS.forEach { generation ->
            if (TOP_3_GENERATIONS.size < 3) TOP_3_GENERATIONS[generation] = generationRating(generation).also {
                FileSupport.TOP_GENERATIONS_BUFFER.append("RATING = $it\n")
            }
            else checkGeneration(generation)
        }
    }

    /**
     * Очень жесткий хардкод, лучше не лезть
     */
    private fun checkGeneration(generation: MutableList<LinkedList<BusStopWithWeight>>) {
        val rating = generationRating(generation)
        TOP_3_GENERATIONS.values.filter { it < rating }.forEach { _ -> TOP_3_GENERATIONS[generation] = rating }
        if (TOP_3_GENERATIONS.size > 3) {
            (0..TOP_3_GENERATIONS.size - 3).onEach {
                var minKey: MutableList<LinkedList<BusStopWithWeight>>? = null
                TOP_3_GENERATIONS.forEach { (t, v) ->
                    val tempMinKey = minKey?.run {
                        if (generationRating(this) > v) t
                        else this
                    } ?: t
                    minKey = tempMinKey
                }
                TOP_3_GENERATIONS.remove(minKey)
            }
            FileSupport.TOP_GENERATIONS_BUFFER.append("\n")
            TOP_3_GENERATIONS.forEach { (_, u) -> FileSupport.TOP_GENERATIONS_BUFFER.append("DISTANCE = $u\n") }
            println("TOP GENERATIONS = ${TOP_3_GENERATIONS.values}")
        }
    }

    fun generationRating(generation: MutableList<LinkedList<BusStopWithWeight>>): Float {
        var rating = 0.0F
        generation.forEach {
            rating += routesBuilder.routeRating(it)
        }
        return rating / generation.size.toFloat()
    }
}