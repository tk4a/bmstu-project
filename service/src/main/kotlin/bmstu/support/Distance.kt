package bmstu.support

import bmstu.dto.HomeToBusStopDistance
import bmstu.dto.entity.BusStopFromDb
import bmstu.dto.entity.HomeFromDb
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Fun compute distance and return mapOf custom Home
 */
fun getNearlyBusStop(homes: List<HomeFromDb>, busStops: List<BusStopFromDb>): Map<Long, HomeToBusStopDistance> {

    val resultSet = mutableMapOf<Long, HomeToBusStopDistance>()

    busStops.forEach { busStopFromDb ->

        val busX = requireNotNull(busStopFromDb.x)
        val busY = requireNotNull(busStopFromDb.y)

        homes.forEach { homeFromDb ->

            val homeX = requireNotNull(homeFromDb.x)
            val homeY = requireNotNull(homeFromDb.y)

            val distance = sqrt((homeX - busX).pow(2.0) + (homeY - busY).pow(2.0))

            val homeId = homeFromDb.home_id

            if (resultSet.containsKey(homeId)) {
                resultSet[homeId]?.let {
                    if (requireNotNull(it.distance) > distance) {
                        it.busStop = requireNotNull(busStopFromDb.global_id)
                        it.distance = distance.toFloat()
                    }
                    resultSet[requireNotNull(homeId)] = it
                }
            } else resultSet[requireNotNull(homeId)] = HomeToBusStopDistance(
                homeId,
                requireNotNull(busStopFromDb.global_id),
                distance.toFloat()
            )
        }
    }

    return resultSet
}