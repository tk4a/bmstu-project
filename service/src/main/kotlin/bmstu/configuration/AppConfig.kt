package bmstu.configuration


import bmstu.algorithm.dto.BusStopWithWeight
import bmstu.algorithm.service.CrossFunctions
import bmstu.algorithm.service.Generation
import bmstu.algorithm.service.RoutesBuilder
import bmstu.algorithm.service.RoutesFunctions
import bmstu.configuration.Constraint.Companion.GENERATION_CAPACITY
import bmstu.support.CoordinatesWriterJson
import bmstu.support.FileSupport
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class AppConfig(
    private val routesBuilder: RoutesBuilder,
    private val writerJson: CoordinatesWriterJson,
    private val generation: Generation,
    private val routesFunctions: RoutesFunctions,
    private val crossFunctions: CrossFunctions
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        val allGen = mutableListOf<MutableList<LinkedList<BusStopWithWeight>>>()
        (0..4).onEach {
             allGen.add(generation.createGeneration(GENERATION_CAPACITY))
        }
        generation.getTopGeneration(allGen)
        FileSupport.writeTopGenerations()

        allGen.forEach {
            routesFunctions.fillTopRoutes(it)
        }
        FileSupport.writeTopRoutes()
        FileSupport.writeMinMaxDistance()
    }
}