package bmstu.dto.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "route_flight")
data class RouteFlight(
    @Id
    val global_id: Long?,
    @Column(name = "route_id")
    val routeId: Long?,
    val service_id: Int?,
    @Column(name = "trip_id")
    val tripId: String?
) {
    constructor() : this(
        null,
        null,
        null,
        null
    )
}
