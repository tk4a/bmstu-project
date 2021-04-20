package bmstu.dto

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "home_distance")
data class HomeToBusStopDistance(
    @Id
    val homeId: Long,
    var busStop: Long,
    var distance: Float
) {
    constructor() : this(0, 0, 0.0F)
}