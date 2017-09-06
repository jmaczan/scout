package pl.jmaczan.scout.server.person.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

@Mapper(componentModel="spring")
interface PersonMapper {

    PersonDto personToPersonDto(Person person);
    Person personDtoToPerson(PersonDto personDto);
}
