package bmstu.support

import bmstu.algorithm.dto.BusStopWithWeight
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

@Service
class CoordinatesWriterJson(
    private val objMapper: ObjectMapper
) {

    fun writeRouteAsJson(route: List<List<BusStopWithWeight>>) {

        val roads = BufferedWriter(FileWriter(File("/Users/tryagain/Downloads/genetic/roads.json")))
        val busStopsWriter = BufferedWriter(FileWriter(File("/Users/tryagain/Downloads/genetic/test.json")))

        val wrapper = mutableListOf<List<List<Float>>>()

        route.forEach {
            var x = 0.0F
            var y = 0.0F
            val wrapper2 = mutableListOf<List<Float>>()
            it.forEach {
                x = ((((it.coordinates.x * 1000) % 1000) % 100) * 30) - 300
                y = ((((it.coordinates.y * 1000) % 1000) % 100) * 10) - 300
                wrapper2.add(mutableListOf(x, y))
            }
            wrapper.add(wrapper2)
        }

        val listBusStops = wrapper.flatMap { it }.flatMap { listOf(it) }

        busStopsWriter.write(listBusStops.toString())
        roads.write(wrapper.toString())
        roads.close()
        busStopsWriter.close()
    }
}