package bmstu.dto.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "home_parsed")
data class HomeFromDb(
    @Id
    var home_id: Long?,
    var full_address: String?,
    var district: String?,
    var x: Double?,
    var y: Double?
) {
    constructor() : this(
        null,
        null,
        null,
        null,
        null)
}