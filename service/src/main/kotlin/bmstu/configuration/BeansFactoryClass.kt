package bmstu.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansFactoryClass {

    @Bean
    fun getObjMapper() = ObjectMapper()
}
