package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import org.springframework.stereotype.Service
import java.util.*

@Service
class CrossFunctions (
    private val routesBuilder: RoutesBuilder
    ) {

    /**
    Функция принимает на вход два поколения, проходит циклом по ним,
    делает скрещивание поколений TO DO...
     **/
    fun crossGenerations(
        generation1: MutableList<LinkedList<BusStopWithWeight>>,
        generation2: MutableList<LinkedList<BusStopWithWeight>>
    ): MutableList<LinkedList<BusStopWithWeight>>? {
        val size = generation1.size
        generation1.forEach { route1 ->
            generation2.forEach { route2 ->
                crossRoutes(route1, route2)?.let {
                    if (routesBuilder.routeRating(it) > routesBuilder.routeRating(
                            generation1.minByOrNull { gen1 -> routesBuilder.routeRating(gen1) }!!
                        )) {
                        generation1.add(it)
                    }
                }
            }
        }

        if (generation1.size > size) {
            generation1.sortBy { routesBuilder.routeRating(it) }
            while (generation1.size != size) generation1.removeFirst()
            return generation1
        }
        return null
    }
}

fun crossRoutes(
    parent1: LinkedList<BusStopWithWeight>,
    parent2: LinkedList<BusStopWithWeight>
): LinkedList<BusStopWithWeight>? {

    var childrenRoute: LinkedList<BusStopWithWeight>? = null

    val firstBusStopParent = parent1.first
    val lastBusStopParent = parent1.last

    checkCrossBusStops(parent1, parent2).takeIf { it }?.let {
        childrenRoute = LinkedList<BusStopWithWeight>()
        var left: Int
        val random = Random()

        left = random.nextInt(parent1.size - 2)

        var right: Int = left + 2

        if (right >= parent1.size - 2) right = left
            .also { left -= 2 }
        if (left < 2) {
            left += 2
            right += 2
        }

        (left..right).onEach {
            childrenRoute?.add(parent1[it])
        }

        var counter = 0

        parent2.forEach { busStop ->
            if (!requireNotNull(childrenRoute).contains(busStop) && busStop != firstBusStopParent
                && busStop != lastBusStopParent) {
                if (counter < 3) childrenRoute?.addLast(busStop) else childrenRoute?.addFirst(busStop)
            }
            counter++
        }
        childrenRoute?.addFirst(firstBusStopParent)
        childrenRoute?.addLast(lastBusStopParent)
    }

    return childrenRoute
}

private fun checkCrossBusStops(
    parent1: LinkedList<BusStopWithWeight>,
    parent2: LinkedList<BusStopWithWeight>
): Boolean {
    parent1.forEachIndexed { index, busStopWithWeight ->
        if (index != 0 && index != parent1.size - 1) {
            if (parent2.contains(busStopWithWeight)) {
                return true
            }
        }
    }
    return false
}