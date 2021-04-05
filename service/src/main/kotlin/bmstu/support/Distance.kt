package bmstu.support

import bmstu.configuration.Constraint.Companion.HOMES
import bmstu.dto.Home
import bmstu.dto.entity.BusStopFromDb
import bmstu.dto.entity.HomeFromDb
import kotlin.math.pow
import kotlin.math.sqrt

fun getNearlyBusStop(home: HomeFromDb, busStop: BusStopFromDb) {
    val homeX = requireNotNull(home.x)
    val homeY = requireNotNull(home.y)

    val busX = requireNotNull(busStop.x)
    val busY = requireNotNull(busStop.y)

    val distance = sqrt((homeX - busX).pow(2.0) + (homeY - busY).pow(2.0))

    val homeId = home.home_id

    if (HOMES.containsKey(homeId)) {
        HOMES[homeId]?.let {
            if (requireNotNull(it.distance) > distance) {
                it.busStop = requireNotNull(busStop.global_id)
                it.distance = distance.toFloat()
            }
            HOMES[requireNotNull(homeId)] = it
        }
    } else HOMES[requireNotNull(homeId)] = Home(
        homeId,
        requireNotNull(busStop.global_id),
        distance.toFloat()
    )
}