package bmstu.dto.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "route_parsed")
data class RouteParsedFromDb(
    @Id
    val global_id: Long? = null,
    @Column(name = "route_id")
    val routeId: Long? = null,
    val agency_code: Int? = null,
    @Column(name = "route_short_name")
    val routeShortName: String? = null,

    @Column(name = "route_long_name")
    val routeLongName: String? = null,
    val route_type: Byte? = null
) {
    constructor() : this(
        global_id = null,
        routeId = null,
        agency_code = null,
        routeShortName = null,
        routeLongName = null,
        route_type = null
    )
}