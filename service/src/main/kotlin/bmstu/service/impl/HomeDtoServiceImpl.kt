package bmstu.service.impl

import bmstu.dto.HomeToBusStopDistance
import bmstu.repository.HomeDtoRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class HomeDtoServiceImpl(
    private val homeDtoRepository: HomeDtoRepository
) : DtoService<HomeToBusStopDistance> {
    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): HomeToBusStopDistance {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<HomeToBusStopDistance> {
        return homeDtoRepository.findAll()
    }

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }

    fun getHomeByBusStop(id: Long): HomeToBusStopDistance = homeDtoRepository.getByBusStop(id)
}
