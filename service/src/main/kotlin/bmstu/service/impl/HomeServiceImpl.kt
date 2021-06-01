package bmstu.service.impl

import bmstu.configuration.Constraint.Companion.TARGET_DISTRICT_HOME
import bmstu.dto.entity.HomeFromDb
import bmstu.repository.HomeRepository
import bmstu.service.DtoService
import org.springframework.stereotype.Service

@Service
class HomeServiceImpl(
    private val homeRepository: HomeRepository
) : DtoService<HomeFromDb> {
    override fun <T> save(obj: T) {
    }

    override fun getAll() = homeRepository.findAllByDistrict(TARGET_DISTRICT_HOME)

    override fun <T : Any> saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): HomeFromDb {
        TODO("Not yet implemented")
    }
}
