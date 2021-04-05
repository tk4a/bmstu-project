package bmstu.repository

import bmstu.dto.entity.BusStopFromDb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BusStopRepository : JpaRepository<BusStopFromDb, Long> {
    fun findAllByDistrict(district: String): List<BusStopFromDb>
}