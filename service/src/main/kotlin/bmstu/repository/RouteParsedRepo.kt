package bmstu.repository

import bmstu.dto.entity.RouteParsedFromDb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteParsedRepo : JpaRepository<RouteParsedFromDb, Long> {

    fun findByRouteId(routeId: Long?): List<RouteParsedFromDb>
    fun findByRouteShortName(routeShortName: String): List<RouteParsedFromDb>
    fun findAllByRouteLongName(routeLongName: String): List<RouteParsedFromDb>
}
