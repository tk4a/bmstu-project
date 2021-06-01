package bmstu.support

import bmstu.algorithm.dto.BusStopWithWeightDto
import org.springframework.stereotype.Service
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.LinkedList
import kotlin.math.pow
import kotlin.math.sqrt

@Service
class CoordinatesWriterJson {

    fun List<BusStopWithWeightDto>.prepareToWrite(): List<BusStopWithWeightDto> {
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

    fun List<BusStopWithWeightDto>.prepareToWriteForFinalRoute(): List<BusStopWithWeightDto?> {
        val resultRoute = LinkedList<BusStopWithWeightDto>()
        val first = this.first()
        val last = this.last()
        val copyRoute = mutableListOf<BusStopWithWeightDto>()
        this.forEach {
            if (it != first && it != last) copyRoute.add(it)
        }
        resultRoute.add(first)
        (0 until copyRoute.size).onEach {
            var minDist = 0.0F
            var currentStop = if (it == 0) first else copyRoute[it]
            var nextStop: BusStopWithWeightDto?
            (0 until copyRoute.size - 1).onEach { inner ->
                nextStop = if (it == 0) copyRoute[inner] else copyRoute[inner + 1]
                var currentDistance = currentStop.getDistance(nextStop!!)
                if (minDist == 0.0F) minDist = currentDistance else {
                    if (minDist > currentDistance) {
                        minDist = currentDistance
                        if (!resultRoute.contains(nextStop)) {
                            resultRoute.add(nextStop!!)
                        }
                    } else {
                        if (currentDistance > minDist && resultRoute.contains(nextStop)) minDist = 0.0F
                    }
                }
            }
            minDist = 0.0F
        }
        resultRoute.add(last)
        return resultRoute
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
                wrapper2.add(mutableListOf(requireNotNull(busStop?.prepareX()), requireNotNull(busStop?.prepareY())))
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
