package bmstu.repository

import bmstu.dto.Home
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HomeDtoRepository : JpaRepository<Home, Long> {
    fun getByBusStop(id: Long): Home
}