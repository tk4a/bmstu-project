package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import org.springframework.stereotype.Service
import java.util.*

@Service
class CrossFunctions (
    private val routesBuilder: RoutesBuilder
    ) {

    /**
    Функция принимает на вход два поколения, делает скрещивание методом двухточечного скрещивания
     и возвращает скрещенное поколение
     **/
    fun crossGenerations(
        generation1: MutableList<LinkedList<BusStopWithWeight>>,
        generation2: MutableList<LinkedList<BusStopWithWeight>>
    ): MutableList<LinkedList<BusStopWithWeight>> {

        val childrenGeneration = mutableListOf<LinkedList<BusStopWithWeight>>()
        val random = Random()
        var left = random.nextInt(generation1.size - 1)
        var right = left + 2
        if (right >= generation1.size - 2) right = left
            .also { left-= 2 }
        if (left < 2) {
            left += 2
            right += 2
        }

        (0..left).onEach {
            childrenGeneration.add(generation1[it])
        }
        (left..right).onEach {
            childrenGeneration.add(generation2[it])
        }
        (right until generation1.size).onEach {
            childrenGeneration.add(generation1[it])
        }
        return childrenGeneration
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