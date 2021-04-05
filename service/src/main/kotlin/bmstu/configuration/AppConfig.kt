package bmstu.configuration

import bmstu.configuration.Constraint.Companion.TOP_BUS_STOPS
import bmstu.service.impl.BusStopServiceImpl
import bmstu.service.impl.HomeDtoServiceImpl
import bmstu.service.impl.HomeServiceImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

@Configuration
class AppConfig(
    private val homeServiceImpl: HomeServiceImpl,
    private val busStopServiceImpl: BusStopServiceImpl,
    private val homeDtoServiceImpl: HomeDtoServiceImpl
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        homeDtoServiceImpl.getAll().let {
            it.forEach { home ->
                if (TOP_BUS_STOPS.containsKey(home.busStop)) {
                    var value = requireNotNull(TOP_BUS_STOPS[home.busStop])
                    value = value.plus(1)
                    TOP_BUS_STOPS[home.busStop] = value
                } else {
                    TOP_BUS_STOPS[home.busStop] = 1
                }
            }
        }
        println(TOP_BUS_STOPS.size)
        println(TOP_BUS_STOPS.toSortedMap())

        val outputFile = BufferedWriter(FileWriter(File("/Users/tryagain/Desktop/homes_coordinates.txt")))
        homeServiceImpl.getAll().forEach {
            outputFile.write(it.y.toString())
            outputFile.newLine()
            outputFile.write(it.x.toString())
            outputFile.newLine()
        }
//        busStopServiceImpl.getAll().forEach {
//            outputFile.write(it.y.toString())
//            outputFile.newLine()
//            outputFile.write(it.x.toString())
//            outputFile.newLine()
//        }
        outputFile.close()
    }
}