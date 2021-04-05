package bmstu.configuration

import bmstu.dto.Home

class Constraint {
    companion object {
        const val TARGET_DISTRICT_HOME = "муниципальный округ Фили-Давыдково"
        const val TARGET_DISTRICT_BUS_STOP = "район Фили-Давыдково"
        val HOMES = mutableMapOf<Long, Home>()
        val TOP_BUS_STOPS = mutableMapOf<Long, Int>()
    }
}