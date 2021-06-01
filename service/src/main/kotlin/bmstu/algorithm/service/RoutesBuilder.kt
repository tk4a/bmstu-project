package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeightDto
import bmstu.algorithm.dto.Coordinate
import bmstu.configuration.Constraint.Companion.ROUTE_SIZE
import bmstu.dto.entity.BusStopFromDbWithWeight
import bmstu.support.BusStopFunClass
import org.springframework.stereotype.Service
import java.util.LinkedList
import java.util.Random

@Service
class RoutesBuilder(
    private val busStopFunClass: BusStopFunClass
) {

    fun getAllBusStopsWithWeight(): List<BusStopFromDbWithWeight> =
        busStopFunClass.getAllBusStopWithWeight()

    fun BusStopFromDbWithWeight.toDto() =
        BusStopWithWeightDto(
            id = requireNotNull(this.global_id),
            name = requireNotNull(this.stationName),
            coordinates = Coordinate(
                x = requireNotNull(this.y?.toFloat()),
                y = requireNotNull(this.x?.toFloat())
            ),
            weight = requireNotNull(this.weight)
        )

    fun getRandomBusStops(): List<BusStopWithWeightDto> {
        val randomBusStops = mutableSetOf<BusStopFromDbWithWeight>()
        val allBusStops = busStopFunClass.getAllBusStopWithWeight()
        val randomNum = Random()
        while (randomBusStops.size != 70) {
            randomBusStops.add(allBusStops[randomNum.nextInt(allBusStops.size - 1)])
        }
        return randomBusStops.map {
            it.toDto()
        }
    }

    fun createRoute(
        start: BusStopWithWeightDto,
        finish: BusStopWithWeightDto,
        busStopDtos: List<BusStopWithWeightDto>
    ): LinkedList<BusStopWithWeightDto> {
        val route = LinkedList<BusStopWithWeightDto>()
        route.add(start)
        (0 until ROUTE_SIZE - 2).onEach {
            val random = Random()
            val num = random.nextInt(busStopDtos.size - 1)
            val busStop = busStopDtos.shuffled()[num]
            if (!(busStop == start && busStop == finish)) route.add(busStop)
        }
        route.add(finish)
        return route
    }

    fun routeRating(route: List<BusStopWithWeightDto>): Float {
        var resultRating = 0.0F
        route.forEach {
            resultRating += it.weight
        }
        return resultRating / route.size.toFloat()
    }
}
