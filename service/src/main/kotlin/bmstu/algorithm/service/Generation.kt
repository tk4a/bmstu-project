package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import bmstu.configuration.Constraint.Companion.TOP_3_GENERATIONS
import bmstu.support.FileSupport
import org.springframework.stereotype.Service
import java.util.*

@Service
class Generation(
    private val routesBuilder: RoutesBuilder
) {

    fun createGeneration(capacity: Int): MutableList<LinkedList<BusStopWithWeight>> {

        val randomBusStops = routesBuilder.getRandomBusStops()
        val generation = mutableListOf(LinkedList<BusStopWithWeight>())
        (0..capacity).onEach {
            generation.add(routesBuilder.createRandomRoute(
                randomBusStops.first(),
                randomBusStops.last(),
                randomBusStops
            ))
        }
        generation.removeFirst()
        return generation
    }

    fun getTopGeneration(allGenerations: List<MutableList<LinkedList<BusStopWithWeight>>>) {
        allGenerations.forEach { generation ->
            if (TOP_3_GENERATIONS.size < 3) TOP_3_GENERATIONS[generation] = generationRating(generation).also {
                FileSupport.TOP_GENERATIONS_BUFFER.append("${generation.first().first.name}\nDISTANCE = $it\n")
            }
            else checkGeneration(generation)
        }
    }

    fun checkGeneration(generation: MutableList<LinkedList<BusStopWithWeight>>) {
        val rating = generationRating(generation)
        TOP_3_GENERATIONS.values.filter { it < rating }.forEach { _ -> TOP_3_GENERATIONS[generation] = rating }
        if (TOP_3_GENERATIONS.size > 3) {
            TOP_3_GENERATIONS.remove(TOP_3_GENERATIONS.toSortedMap( compareBy { generationRating(it) } ).firstKey())
            FileSupport.TOP_GENERATIONS_BUFFER.append("\n")
            TOP_3_GENERATIONS.forEach { (t, u) -> FileSupport.TOP_GENERATIONS_BUFFER.append("${t.first().first.name}\n DISTANCE = $u\n") }
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