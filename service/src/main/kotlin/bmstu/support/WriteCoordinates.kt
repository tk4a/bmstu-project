package bmstu.support

import bmstu.algorithm.dto.BusStopWithWeight
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

fun writeCoordinatesBusStopWithWeight(busStops: List<BusStopWithWeight>) {
    val outputFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/test1.txt")))

    busStops.forEach {
        outputFile.write(it.coordinates.x.toString())
        outputFile.newLine()
        outputFile.write(it.coordinates.y.toString())
        outputFile.newLine()
    }
    outputFile.close()
}