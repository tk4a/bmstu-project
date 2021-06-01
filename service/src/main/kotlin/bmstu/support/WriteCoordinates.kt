package bmstu.support

import bmstu.algorithm.dto.BusStopWithWeightDto
import bmstu.dto.entity.BusStopFromDb
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

fun writeCoordinates(busStops: List<BusStopFromDb>) {
    val outputFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/test1.txt")))

    busStops.forEach {
        outputFile.write(it.y.toString())
        outputFile.newLine()
        outputFile.write(it.x.toString())
        outputFile.newLine()
    }
    outputFile.close()
}

fun writeCoordinatesBusStopWithWeight(busStopDtos: List<BusStopWithWeightDto>) {
    val outputFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/test1.txt")))

    busStopDtos.forEach {
        outputFile.write(it.coordinates.x.toString())
        outputFile.newLine()
        outputFile.write(it.coordinates.y.toString())
        outputFile.newLine()
    }
    outputFile.close()
}
