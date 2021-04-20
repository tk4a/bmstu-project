package bmstu.service.impl

import bmstu.dto.entity.RouteFlight
import bmstu.repository.RouteFlightRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class RouteFlightServiceImpl(
    private val routeFlightRepository: RouteFlightRepository
) : DtoService<RouteFlight> {

    fun findByTripId(tripId: String?) = routeFlightRepository.getByTripId(requireNotNull(tripId))

    fun findByRouteId(routeId: Long) = routeFlightRepository.getByRouteId(routeId)

    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): RouteFlight {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<*> {
        TODO("Not yet implemented")
    }

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}