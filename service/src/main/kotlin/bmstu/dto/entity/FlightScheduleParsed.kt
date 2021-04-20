package bmstu.dto.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import java.sql.Time
import javax.persistence.Column

@Entity
@Table(name = "flight_schedule_parsed")
data class FlightScheduleParsed(
    @Id
    val global_id: Long?,
    @Column(name = "trip_id")
    val tripId: String?,
    val arrival_time: Time?,
    val departure_time: Time?,
    @Column(name = "stop_id")
    val stopId: Int?,
    val stop_sequence: Short?
) {
    constructor() : this(
        global_id = null,
        tripId = null,
        arrival_time = null,
        departure_time = null,
        stopId = null,
        stop_sequence = null
    )
}