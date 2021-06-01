package bmstu.repository

import bmstu.dto.entity.HomeFromDb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HomeRepository : JpaRepository<HomeFromDb, Long> {
    fun findAllByDistrict(district: String): List<HomeFromDb>
}
