package pl.jmaczan.scout.server.person.domain;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

@Mapper(componentModel="spring")
@Component
@DecoratedWith(PersonMapperDecorator.class)
interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);
    Person personDtoToPerson(PersonDto personDto);
}
