package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import bmstu.algorithm.dto.Coordinate
import bmstu.configuration.Constraint.Companion.ROUTE_SIZE
import bmstu.configuration.Constraint.Companion.TARGET_DISTRICT_BUS_STOP
import bmstu.dto.entity.BusStopFromDb
import bmstu.support.BusStopFunClass
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoutesBuilder(
    private val busStopFunClass: BusStopFunClass
) {
    fun getRandomBusStops(): List<BusStopWithWeight> {
        val randomBusStops = mutableSetOf<BusStopFromDb>()
        val allBusStops = busStopFunClass.findAllBusStopByDistrict(TARGET_DISTRICT_BUS_STOP).toList()
        val randomNum = Random()
        while (randomBusStops.size != 70) {
            randomBusStops.add(allBusStops[randomNum.nextInt(allBusStops.size - 1)])
        }
        return randomBusStops.map {
            BusStopWithWeight(
                id = requireNotNull(it.global_id),
                name = requireNotNull(it.stationName),
                coordinates = Coordinate(
                    x = requireNotNull(it.y?.toFloat()),
                    y = requireNotNull(it.x?.toFloat())
                ),
                weight = randomNum.nextFloat()
            )
        }.toList()
    }

    fun createRandomRoute(
        start: BusStopWithWeight,
        finish: BusStopWithWeight,
        busStops: List<BusStopWithWeight>
    ): LinkedList<BusStopWithWeight> {
        val randomRoute = LinkedList<BusStopWithWeight>()
        randomRoute.add(start)
        busStops.shuffled().take(ROUTE_SIZE).forEach {
            if (!(it == start && it == finish)) randomRoute.add(it)
        }
        randomRoute.add(finish)
        return randomRoute
    }

    fun routeRating(route: List<BusStopWithWeight>): Float {
        var resultRating = 0.0F
        route.forEach {
            resultRating += it.weight
        }
        return resultRating / route.size.toFloat()
    }
}