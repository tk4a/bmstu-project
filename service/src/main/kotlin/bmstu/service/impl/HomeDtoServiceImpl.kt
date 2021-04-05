package bmstu.service.impl

import bmstu.dto.Home
import bmstu.repository.HomeDtoRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class HomeDtoServiceImpl(
    private val homeDtoRepository: HomeDtoRepository
) : DtoService<Home> {
    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): Home {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Home> {
        return homeDtoRepository.findAll()
    }

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }

    fun getHomeByBusStop(id: Long): Home = homeDtoRepository.getByBusStop(id)
}