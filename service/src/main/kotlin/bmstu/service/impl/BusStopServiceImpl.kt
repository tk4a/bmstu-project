package bmstu.service.impl

import bmstu.dto.entity.BusStopFromDb
import bmstu.repository.BusStopRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
data class BusStopServiceImpl(
    val busStopRepository: BusStopRepository
) : DtoService<BusStopFromDb> {
    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getAll() = busStopRepository.findAll()

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): BusStopFromDb {
        return busStopRepository.getOne(id)
    }

}