package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeightDto
import bmstu.algorithm.dto.Coordinate
import bmstu.configuration.Constraint.Companion.ROUTE_SIZE
import bmstu.dto.entity.BusStopFromDbWithWeight
import bmstu.support.BusStopFunClass
import org.springframework.stereotype.Service
import java.util.*

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
        busStopDtos.shuffled()
            .take(ROUTE_SIZE).forEach {
            if (!(it == start && it == finish)) route.add(it)
        }
        route.add(finish)
        println(route.size)
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