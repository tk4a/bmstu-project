package bmstu.dto.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bus_stop_from_phili")
class BusStopFromDbWithWeight(
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
    val y: Double?,
    val weight: Float?
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
        null,
        null
    )
}