package pl.jmaczan.scout.server.person.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MapperConfiguration {

    @Bean
    PersonMapper personMapper() {
        return new PersonMapperImpl();
    }
}
