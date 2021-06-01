package bmstu.repository

import bmstu.dto.entity.BusStopFromDbWithWeight
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BusStopWeightRepository : JpaRepository<BusStopFromDbWithWeight, Long>
