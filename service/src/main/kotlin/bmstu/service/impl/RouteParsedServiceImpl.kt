package bmstu.service.impl

import bmstu.dto.entity.RouteParsedFromDb
import bmstu.repository.RouteParsedRepo
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class RouteParsedServiceImpl(
    private val routeParsedRepo: RouteParsedRepo
) : DtoService<RouteParsedFromDb> {

    fun findAllByRouteLongName(routeName: String) =
        routeParsedRepo.findAllByRouteLongName(routeName)

    fun findAllByRouteId(routeId: Long) =
        routeParsedRepo.findByRouteId(routeId)

    fun findAllByRouteShortName(routeShortName: String) =
        routeParsedRepo.findByRouteShortName(routeShortName)

    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): RouteParsedFromDb {
        TODO("Not yet implemented")
    }

    override fun getAll() = routeParsedRepo.findAll()

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}
