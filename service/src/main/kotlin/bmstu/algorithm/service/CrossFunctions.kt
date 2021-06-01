package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeightDto
import org.springframework.stereotype.Service
import java.util.LinkedList
import java.util.Random

@Service
class CrossFunctions(
    private val routesBuilder: RoutesBuilder
) {

    /**
     Функция принимает на вход две популяции, делает скрещивание методом двухточечного скрещивания
     и возвращает скрещенную популяцию
     **/
    fun crossPopulation(
        population1: MutableList<LinkedList<BusStopWithWeightDto>>,
        population2: MutableList<LinkedList<BusStopWithWeightDto>>
    ): MutableList<LinkedList<BusStopWithWeightDto>> {

        val childrenGeneration = mutableListOf<LinkedList<BusStopWithWeightDto>>()
        val random = Random()
        var left = random.nextInt(population1.size - 1)
        var right = left + 2
        if (right >= population1.size - 2) right = left
            .also { left -= 2 }
        if (left < 2) {
            left += 2
            right += 2
        }

        (0..left).onEach {
            childrenGeneration.add(population1[it])
        }
        (left..right).onEach {
            childrenGeneration.add(population1[it])
        }
        (right until population1.size).onEach {
            childrenGeneration.add(population1[it])
        }
        return childrenGeneration
    }
}

fun crossRoutes(
    parent1: LinkedList<BusStopWithWeightDto>,
    parent2: LinkedList<BusStopWithWeightDto>
): LinkedList<BusStopWithWeightDto>? {

    var childrenRoute: LinkedList<BusStopWithWeightDto>? = null

    val firstBusStopParent = parent1.first
    val lastBusStopParent = parent1.last

    checkCrossBusStops(parent1, parent2).takeIf { it }?.let {
        childrenRoute = LinkedList<BusStopWithWeightDto>()
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
            if (!requireNotNull(childrenRoute).contains(busStop) && busStop != firstBusStopParent &&
                busStop != lastBusStopParent
            ) {
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
    parent1: LinkedList<BusStopWithWeightDto>,
    parent2: LinkedList<BusStopWithWeightDto>
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
