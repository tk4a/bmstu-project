package bmstu.repository

import bmstu.dto.HomeToBusStopDistance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HomeDtoRepository : JpaRepository<HomeToBusStopDistance, Long> {
    fun getByBusStop(id: Long): HomeToBusStopDistance
}