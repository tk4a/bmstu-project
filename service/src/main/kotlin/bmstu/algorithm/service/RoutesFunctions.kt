package bmstu.algorithm.service

import bmstu.algorithm.dto.BusStopWithWeight
import bmstu.configuration.Constraint.Companion.TOP_3_ROUTES
import bmstu.support.FileSupport
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoutesFunctions(
    private val routesBuilder: RoutesBuilder
) {

    /**
     * Функция заполняет топ 3 маршрута, если коллекция пустая, если в ней есть значения, то проверяет что
     * минимальное значение в коллекции больше текущего рейтинга, если это не истина, тогда минимальное значение заменяется на текущее
     */
    fun fillTopRoutes(generation: MutableList<LinkedList<BusStopWithWeight>>) {
        generation.forEach {
            if (TOP_3_ROUTES.size < 3) {
                TOP_3_ROUTES[it] = routesBuilder.routeRating(it).also { rating ->
                    FileSupport.TOP_ROUTES_BUFFER.append("${it.first.name} \n RATING = $rating\n")
                }
            } else checkTopRoutes(it)
        }
    }

    private fun checkTopRoutes(route: LinkedList<BusStopWithWeight>) {
        val rating = routesBuilder.routeRating(route)
        TOP_3_ROUTES.values.filter { it < rating }.forEach { _ -> TOP_3_ROUTES[route] = rating }
        if (TOP_3_ROUTES.size > 3) {
            TOP_3_ROUTES.remove(TOP_3_ROUTES.toSortedMap( compareBy { routesBuilder.routeRating(it) }).firstKey())
            val top3routes = TOP_3_ROUTES.toSortedMap( compareBy { routesBuilder.routeRating(it) } )
            FileSupport.MIN_MAX_DISTANCE_BUFFER.append("MIN = ${top3routes[top3routes.firstKey()].toString()}\n")
            FileSupport.MIN_MAX_DISTANCE_BUFFER.append("MAX = ${top3routes[top3routes.lastKey()].toString()}\n")
            FileSupport.TOP_ROUTES_BUFFER.append("\n")
            TOP_3_ROUTES.forEach { (t, u) -> FileSupport.TOP_ROUTES_BUFFER.append("${t.first.name} \n RATING = $u\n") }
            println(TOP_3_ROUTES.values)
        }
    }
}