package bmstu.service

interface DtoService<T> {
    fun <T>save(obj: T)
    fun getOne(id: Long): T
    fun getAll(): List<*>
    fun <T : Any>saveAll(list: List<T>)
}