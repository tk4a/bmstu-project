package bmstu.repository

import bmstu.dto.entity.FlightScheduleParsed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FlightScheduleRepository : JpaRepository<FlightScheduleParsed, Long> {
    fun getFlightScheduleParsedByStopId(stop_id: Int?): List<FlightScheduleParsed>
    fun getByTripId(tripId: String): List<FlightScheduleParsed>
}
