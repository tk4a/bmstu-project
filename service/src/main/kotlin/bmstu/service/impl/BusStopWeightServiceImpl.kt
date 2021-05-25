package bmstu.service.impl

import bmstu.dto.entity.BusStopFromDbWithWeight
import bmstu.repository.BusStopWeightRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class BusStopWeightServiceImpl(
    private val busStopWeightRepo: BusStopWeightRepository
) : DtoService<BusStopFromDbWithWeight> {
    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): BusStopFromDbWithWeight {
        TODO("Not yet implemented")
    }

    override fun getAll() = busStopWeightRepo.findAll()

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}