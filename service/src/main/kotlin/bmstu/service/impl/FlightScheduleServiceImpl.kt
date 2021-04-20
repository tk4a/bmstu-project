package bmstu.service.impl

import bmstu.dto.entity.FlightScheduleParsed
import bmstu.repository.FlightScheduleRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class FlightScheduleServiceImpl(
    val flightScheduleRepository: FlightScheduleRepository
) : DtoService<FlightScheduleParsed> {

    fun getFlightScheduleByStopId(stop_id: Int?) =
        flightScheduleRepository.getFlightScheduleParsedByStopId(stop_id)

    fun findAllByTripId(tripId: String) =
        flightScheduleRepository.getByTripId(tripId)

    override fun <T> save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): FlightScheduleParsed {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<*> {
        return flightScheduleRepository.findAll()
    }

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}