package bmstu.configuration

import bmstu.algorithm.dto.BusStopWithWeightDto
import java.util.*

class Constraint {
    companion object {
        const val TARGET_DISTRICT_HOME = "муниципальный округ Фили-Давыдково"
        const val TARGET_DISTRICT_BUS_STOP = "район Фили-Давыдково"
        const val ROUTE_SIZE = 15
        val TOP_3_POPULATION = mutableMapOf<MutableList<LinkedList<BusStopWithWeightDto>>, Float>()
        val TOP_3_ROUTES = mutableMapOf<LinkedList<BusStopWithWeightDto>, Float>()
        val ALL_GENERATIONS = mutableListOf<MutableList<LinkedList<BusStopWithWeightDto>>>()
        val ALL_ROUTES_LOGS = mutableListOf<List<LinkedList<BusStopWithWeightDto>>>()
        const val POPULATION_CAPACITY = 10 // Количество маршрутов в одной популяции
        const val START_GENERATION_CAPACITY = 10 // Стартовое наполнение поколения
        const val SELECTED_POPULATION = 10 // Количество отобранных популяций в поколении
        const val PATH_FOR_TOP_ROUTES = "/Users/tryagain/Downloads/genetic/roads.json"
        const val PATH_FOR_TOP_STOPS = "/Users/tryagain/Downloads/genetic/test.json"
        const val PATH_FOR_START_ROUTES = "/Users/tryagain/Desktop/genetic/roads.json"
        const val PATH_FOR_START_STOPS = "/Users/tryagain/Desktop/genetic/test.json"
        const val STOP_POINT = 0.90F
    }
}