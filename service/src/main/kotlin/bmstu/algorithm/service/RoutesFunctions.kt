package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeightDto
import bmstu.configuration.Constraint.Companion.ALL_ROUTES_LOGS
import bmstu.configuration.Constraint.Companion.POPULATION_CAPACITY
import bmstu.configuration.Constraint.Companion.TOP_3_ROUTES
import bmstu.support.FileSupport
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoutesFunctions(
    private val routesBuilder: RoutesBuilder,
    private val generation: Generation
) {

    /**
     * Функция заполняет топ 3 маршрута, если коллекция пустая, если в ней есть значения, то проверяет что
     * минимальное значение в коллекции больше текущего рейтинга, если это не истина, тогда минимальное значение заменяется на текущее
     */
    fun fillTopRoutes(population: MutableList<LinkedList<BusStopWithWeightDto>>) {
        population.forEach {
            if (TOP_3_ROUTES.size < 3) {
                TOP_3_ROUTES[it] = routesBuilder.routeRating(it).also { rating ->
                    FileSupport.TOP_ROUTES_BUFFER.append("RATING = $rating\n")
                }
            } else checkTopRoutes(it)
        }
    }

    fun selected(population: MutableList<LinkedList<BusStopWithWeightDto>>) {
        if (population.size > POPULATION_CAPACITY) {
            population.sortBy { routesBuilder.routeRating(it) }
            (0 until population.size - POPULATION_CAPACITY).onEach { population.removeFirst() }
        }
    }

    private fun checkTopRoutes(route: LinkedList<BusStopWithWeightDto>) {
        val rating = routesBuilder.routeRating(route)
        TOP_3_ROUTES.values.filter { it < rating }.forEach { _ -> TOP_3_ROUTES[route] = rating }
        if (TOP_3_ROUTES.size > 3) {
            TOP_3_ROUTES.remove(TOP_3_ROUTES.toSortedMap( compareBy { routesBuilder.routeRating(it) }).firstKey())
            val top3routes = TOP_3_ROUTES.toSortedMap( compareBy { routesBuilder.routeRating(it) } )
            FileSupport.MIN_MAX_DISTANCE_BUFFER.append("MIN TOP 3 = ${top3routes[top3routes.firstKey()].toString()}\n")
            FileSupport.MIN_MAX_DISTANCE_BUFFER.append("MAX TOP 3 = ${top3routes[top3routes.lastKey()].toString()}\n\n")
            FileSupport.TOP_ROUTES_BUFFER.append("\n")
            TOP_3_ROUTES.forEach { (_, u) -> FileSupport.TOP_ROUTES_BUFFER.append("RATING = $u\n") }
            ALL_ROUTES_LOGS.add(TOP_3_ROUTES.keys.toList())
        }
    }

    fun fillSetAllRoutes(): MutableSet<LinkedList<BusStopWithWeightDto>> {
        ALL_ROUTES_LOGS.toSortedSet(compareBy { generation.populationRating(it.toMutableList()) })
//        val firstTopRoute = ALL_ROUTES_LOGS[(ALL_ROUTES_LOGS.size / 2) / 2].last()
        val lastTopRoute = ALL_ROUTES_LOGS.last().last()
        val middleTopRoute = ALL_ROUTES_LOGS[ALL_ROUTES_LOGS.size / 2].last()
        return mutableSetOf(middleTopRoute, lastTopRoute)

    }
}