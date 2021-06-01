package bmstu.support

import bmstu.dto.entity.BusStopFromDb
import bmstu.dto.entity.FlightScheduleParsed
import bmstu.dto.entity.RouteFlight
import bmstu.dto.entity.RouteParsedFromDb
import bmstu.service.impl.RouteFlightServiceImpl
import bmstu.service.impl.RouteParsedServiceImpl

fun getRouteFlightByTripId(
    flightScheduleList: List<FlightScheduleParsed>,
    routeFlightServiceImpl: RouteFlightServiceImpl
): List<RouteFlight> {
    val routeFlightList = mutableListOf<RouteFlight>()

    flightScheduleList.forEach { fs ->
        routeFlightServiceImpl.findByTripId(fs.tripId).forEach { routeFlight ->
            routeFlightList.add(routeFlight)
        }
    }

    return routeFlightList
}

fun getRouteParsedByRouteId(
    routeFlightList: List<RouteFlight>,
    routeParsedServiceImpl: RouteParsedServiceImpl
): List<RouteParsedFromDb> {
    val routeParsedList = mutableListOf<RouteParsedFromDb>()

    routeFlightList.forEach { routeFlight ->
        routeParsedServiceImpl.findAllByRouteId(requireNotNull(routeFlight.routeId)).forEach { routeParsedFromDb ->
            routeParsedList.add(routeParsedFromDb)
        }
    }
    return routeParsedList
}

fun BusStopFromDb.getSetRoutes(): Set<String> {
    val routes = mutableSetOf<String>()
    routeNumbers?.split(";")?.forEach { route ->
        routes.add(
            route.trim().subSequence(1, route.trim().length).toString()
        )
    }
    return routes
}
