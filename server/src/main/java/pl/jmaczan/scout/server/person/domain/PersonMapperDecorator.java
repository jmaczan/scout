package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

@Component
class PersonMapperDecorator implements PersonMapper {

    @Autowired
    private PersonMapper delegate;

    @Override
    public PersonDto personToPersonDto(Person person) {
        PersonDto personDto = delegate.personToPersonDto(person);
        personDto.setForename(person.getForename().getValue());
        personDto.setSurname(person.getSurname().getValue());
        return personDto;
    }

    @Override
    public Person personDtoToPerson(PersonDto personDto) {
        Person person = delegate.personDtoToPerson(personDto);
        person.setForename(new Forename(personDto.getForename()));
        person.setSurname(new Surname(personDto.getSurname()));
        return person;
    }

    List<PersonDto> personsToPersonDtos(List<Person> personList) {
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.stream().forEach(person -> personDtoList.add(personToPersonDto(person)));
        return personDtoList;
    }

    List<Person> personDtosToPersonList(List<PersonDto> personDtoList) {
        List<Person> personList = new ArrayList<>();
        personDtoList.stream().forEach(personDto -> personList.add(personDtoToPerson(personDto)));
        return personList;
    }
}
