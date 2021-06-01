package bmstu.support

import bmstu.dto.entity.BusStopFromDb
import bmstu.dto.entity.RouteParsedFromDb
import bmstu.service.impl.BusStopServiceImpl
import bmstu.service.impl.FlightScheduleServiceImpl
import bmstu.service.impl.RouteFlightServiceImpl
import bmstu.service.impl.RouteParsedServiceImpl
import kotlinx.coroutines.channels.Channel
import org.springframework.stereotype.Service

@Service
class RouteFunClass(
    private val routeParsedServiceImpl: RouteParsedServiceImpl,
    private val routeFlightServiceImpl: RouteFlightServiceImpl,
    private val flightServiceImpl: FlightScheduleServiceImpl,
    private val busStopServiceImpl: BusStopServiceImpl
) {

    private val channel = Channel<Set<BusStopFromDb>>()

    private var size = 0

    fun findAllRoutesByName(routeName: String): List<RouteParsedFromDb> =
        routeParsedServiceImpl.findAllByRouteShortName(routeName)

    fun findAllRouteByLongName(longName: String): Set<RouteParsedFromDb> {
        val routes = mutableSetOf<RouteParsedFromDb>()
        routeParsedServiceImpl.getAll().forEach { route ->
            route as RouteParsedFromDb
            if (requireNotNull(route.routeLongName?.contains(longName))) {
                routes.add(route)
            }
        }
        return routes
    }

//    fun findAllRouteFlightByRouteId(routeParsed: RouteParsedFromDb): List<RouteFlight> =
//        routeFlightServiceImpl.findByRouteId(requireNotNull(routeParsed.routeId))

//    fun findAllBusStopsByRouteName(routeName: String) = runBlocking {
//        val busStopByRouteName = mutableSetOf<BusStopFromDb>()
//
//        findAllRoutesByName(routeName = routeName)
//
//        findAllRoutesByName(routeName).forEach { route ->
//            routeFlightServiceImpl.findByRouteId(requireNotNull(route.routeId)).first().forEach { routeFlight ->
//                flightServiceImpl.findAllByTripId(requireNotNull(routeFlight.tripId)).forEach { flightScheduleParsed ->
//                    busStopWithStopIdServiceImpl.findAllByStopId(requireNotNull(flightScheduleParsed.stopId)).forEach { busStopWithStopIdFromDb ->
//                        launch {
//                            busStopByRouteName.add(busStopWithStopIdFromDb)
//                            channel.send(busStopByRouteName)
//                            size++
//                        }
//                        channel.receive().let {
//                            println("----START----")
//                            it.forEach { bs ->
//                                println()
//                                println(bs)
//                                println()
//                            }
//                            println("----END----")
//                            println("SIZE = ${busStopByRouteName.size}")
//                            println()
//                        }
//                    }
//                }
//            }
//        }
//    }
}
