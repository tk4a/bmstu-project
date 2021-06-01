package bmstu.repository

import bmstu.dto.entity.RouteFlight
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteFlightRepository : JpaRepository<RouteFlight, Long> {
    fun getByTripId(tripId: String): List<RouteFlight>
    fun getByRouteId(routeId: Long): List<RouteFlight>
}
