package bmstu.support

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

object FileSupport {

    val TOP_GENERATIONS_BUFFER = StringBuilder()
    val TOP_ROUTES_BUFFER = StringBuilder()
    val MIN_MAX_DISTANCE_BUFFER = StringBuilder()
    val ALL_GENERATIONS_RATING = StringBuilder()

    fun writeTopRoutes() {
        val topRoutesFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/topRoutes.txt")))
        topRoutesFile.write(TOP_ROUTES_BUFFER.toString())
        topRoutesFile.close()
    }

    fun writeTopGenerations() {
        val topGenerationsFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/topGenerations.txt")))
        topGenerationsFile.write(TOP_GENERATIONS_BUFFER.toString())
        topGenerationsFile.close()
    }

    fun writeMinMaxDistance() {
        val minMaxDistance = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/minmax.txt")))
        minMaxDistance.write(MIN_MAX_DISTANCE_BUFFER.toString())
        minMaxDistance.close()
    }

    fun writeAllGenRating() {
        val minMaxDistance = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/allgencommonrating.txt")))
        minMaxDistance.write(ALL_GENERATIONS_RATING.toString())
        minMaxDistance.close()
    }
}
