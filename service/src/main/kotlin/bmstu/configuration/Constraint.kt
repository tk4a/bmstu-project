package bmstu.configuration

import bmstu.algorithm.dto.BusStopWithWeight
import java.util.*

class Constraint {
    companion object {
        const val TARGET_DISTRICT_HOME = "муниципальный округ Фили-Давыдково"
        const val TARGET_DISTRICT_BUS_STOP = "район Фили-Давыдково"
        const val ROUTE_SIZE = 10
        val TOP_3_POPULATION = mutableMapOf<MutableList<LinkedList<BusStopWithWeight>>, Float>()
        val TOP_3_ROUTES = mutableMapOf<LinkedList<BusStopWithWeight>, Float>()
        val ALL_GENERATIONS = mutableListOf<MutableList<LinkedList<BusStopWithWeight>>>()
        const val POPULATION_CAPACITY = 10 // Количество маршрутов в одной популяции
        const val START_GENERATION_CAPACITY = 10 // Стартовое наполнение поколения
        const val SELECTED_POPULATION = 10 // Количество отобранных популяций в поколении
        const val SELECTED_ROUTES = 10
        const val STOP_POINT = 0.70F
    }
}