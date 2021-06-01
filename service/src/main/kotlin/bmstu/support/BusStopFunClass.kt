package bmstu.support

import bmstu.configuration.Constraint.Companion.TARGET_DISTRICT_BUS_STOP
import bmstu.dto.HomeToBusStopDistance
import bmstu.dto.entity.BusStopFromDb
import bmstu.dto.entity.BusStopFromDbWithWeight
import bmstu.service.impl.BusStopServiceImpl
import bmstu.service.impl.BusStopWeightServiceImpl
import bmstu.service.impl.RouteParsedServiceImpl
import org.springframework.stereotype.Service

@Service
class BusStopFunClass(
    private val busStopServiceImpl: BusStopServiceImpl,
    private val routeFunClass: RouteFunClass,
    private val routeParsedServiceImpl: RouteParsedServiceImpl,
    private val busStopFromDbWithWeightServiceImpl: BusStopWeightServiceImpl
) {

    fun getAllBusStopWithWeight(): List<BusStopFromDbWithWeight> {
        return busStopFromDbWithWeightServiceImpl.getAll()
    }
    fun getTopBusStops(topList: Map<Long, HomeToBusStopDistance>) {

        val homesToBusStopsDistance = topList.values.map { it.busStop }.toList()
        val setHomesToBusStops = topList.values.map { it.busStop }.toSet()
        val busStops = mutableMapOf<BusStopFromDb, Int>()

        busStopServiceImpl.getAll().forEach { busStopFromDb ->
            if (setHomesToBusStops.contains(busStopFromDb.global_id)) busStops[busStopFromDb] = 0
        }

        homesToBusStopsDistance.forEach { home ->
            busStops.keys.forEach {
                if (it.global_id == home) {
                    var counter = requireNotNull(busStops[it])
                    counter++
                    busStops[it] = counter
                }
            }
        }

        busStops.forEach { (busStop, count) ->
            println()
            println(busStop)
            println("COUNT => $count")
        }
    }

    fun findAllBusStopByDistrict(district: String): Set<BusStopFromDb> {

        val resultBusSet = mutableSetOf<BusStopFromDb>()

        busStopServiceImpl.getAll().forEach { busStopFromDb ->
            if (requireNotNull(busStopFromDb.district?.contains(district))) {
                resultBusSet.add(busStopFromDb)
            }
        }

        return resultBusSet
    }

    fun findAllBusStopTo(to: String): Set<BusStopFromDb> {
        val busStopsTo = mutableSetOf<BusStopFromDb>()

        val routesByDistrict = mutableSetOf<String>()

        findAllBusStopByDistrict(TARGET_DISTRICT_BUS_STOP).forEach { busStopByDistrict ->

            if (requireNotNull(busStopByDistrict.stationName?.contains(to))) {
                routesByDistrict.addAll(busStopByDistrict.getSetRoutes())
                busStopsTo.add(busStopByDistrict)
            }
        }

        busStopsTo.forEach {
            println()
            println(it.stationName)
            println(it.street)
            println(it.routeNumbers)
            println()
        }
        println(routesByDistrict)

        return busStopsTo
    }

    fun findAllBusStopsByRouteName(routeName: String): List<BusStopFromDb> {

        val allBusStops = busStopServiceImpl.getAll()

        val allBusStopsByRouteName = mutableListOf<BusStopFromDb>()

        val routeByName = routeFunClass.findAllRoutesByName(routeName).first()

        allBusStops.forEach { busStopFromDb ->
            val busRoutes = busStopFromDb.getSetRoutes()
            if (busRoutes.contains(routeByName.routeShortName)) {
                allBusStopsByRouteName.add(busStopFromDb)
            }
        }

        allBusStopsByRouteName.forEach {
            println()
            println(it)
            println()
        }
        println(allBusStopsByRouteName.size)

        return allBusStopsByRouteName
    }
}
