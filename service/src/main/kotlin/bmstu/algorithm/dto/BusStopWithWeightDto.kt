package bmstu.algorithm.dto

data class BusStopWithWeightDto(
    val id: Long,
    val name: String,
    val coordinates: Coordinate,
    val weight: Float
)
