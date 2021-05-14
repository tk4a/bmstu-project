package bmstu.algorithm.dto

data class BusStopWithWeight(
    val id: Long,
    val name: String,
    val coordinates: Coordinate,
    val weight: Float
)