package bmstu.dto.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bus_stop_details")
data class BusStopFromDb (
    @Id
    val global_id: Long?,
    val street: String?,
    val admArea: String?,
    val district: String?,
    val routeNumbers: String?,
    val stationName: String?,
    val pavilion: String?,
    val operatingOrgName: String?,
    val entryState: String?,
    val x: Double?,
    val y: Double?
) {
    constructor() : this(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null)
}