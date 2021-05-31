package bmstu.support

import bmstu.algorithm.dto.BusStopWithWeightDto
import org.springframework.stereotype.Service
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import kotlin.math.pow
import kotlin.math.sqrt

@Service
class CoordinatesWriterJson {

    fun List<BusStopWithWeightDto>.prepareToWrite() : List<BusStopWithWeightDto> {
        val firstStop = this.first()
        val lastStop = this.last()
        val mainRoute = mutableListOf<BusStopWithWeightDto>()
        this.forEach {
            if (it != firstStop && it != lastStop) {
                mainRoute.add(it)
            }
        }
        mainRoute.sortBy { it.getDistance(firstStop) }
        return mainRoute
    }

    fun BusStopWithWeightDto.getDistance(firstStop: BusStopWithWeightDto): Float =
        sqrt((this.coordinates.x - firstStop.coordinates.x).pow(2) + (this.coordinates.y - firstStop.coordinates.y).pow(2))

    fun writeRouteAsJson(route: List<List<BusStopWithWeightDto>>, pathRoads: String, pathBusStops: String) {

        val roads = BufferedWriter(FileWriter(File(pathRoads)))
        val busStopsWriter = BufferedWriter(FileWriter(File(pathBusStops)))

        val wrapper = mutableListOf<List<List<Float>>>()

        route.forEach {
            println("size route for picture ${it.size}")
            val wrapper2 = mutableListOf<List<Float>>()
            val firstStop = it.first()
            val lastStop = it.last()

            wrapper2.add(mutableListOf(firstStop.prepareX(), firstStop.prepareY()))
            it.prepareToWrite().forEach { busStop ->
                wrapper2.add(mutableListOf(busStop.prepareX(), busStop.prepareY()))
            }
            wrapper2.add(mutableListOf(lastStop.prepareX(), lastStop.prepareY()))
            wrapper.add(wrapper2)
        }

        val listBusStops = wrapper.flatMap { it }.flatMap { listOf(it) }

        busStopsWriter.write(listBusStops.toString())
        roads.write(wrapper.toString())
        roads.close()
        busStopsWriter.close()
    }

    fun BusStopWithWeightDto.prepareX() = ((((this.coordinates.x * 1000) % 1000) % 100) * 30) - 300
    fun BusStopWithWeightDto.prepareY() = ((((this.coordinates.y * 1000) % 1000) % 100) * 10) - 300
}