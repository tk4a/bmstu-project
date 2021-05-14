package bmstu.configuration

import bmstu.algorithm.dto.BusStopWithWeight
import java.util.*

class Constraint {
    companion object {
        const val TARGET_DISTRICT_HOME = "муниципальный округ Фили-Давыдково"
        const val TARGET_DISTRICT_BUS_STOP = "район Фили-Давыдково"
        const val ROUTE_SIZE = 10
        val TOP_3_GENERATIONS = mutableMapOf<MutableList<LinkedList<BusStopWithWeight>>, Float>()
        val TOP_3_ROUTES = mutableMapOf<LinkedList<BusStopWithWeight>, Float>()
        const val GENERATION_CAPACITY = 10
    }
}