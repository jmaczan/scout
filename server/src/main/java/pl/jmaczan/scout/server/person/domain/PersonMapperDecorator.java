package pl.jmaczan.scout.server.person.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

@Component
class PersonMapperDecorator implements PersonMapper {

    @Autowired
    @Qualifier("delegate")
    private PersonMapper delegate;

    @Override
    public PersonDto personToPersonDto(Person person) {
        PersonDto personDto = delegate.personToPersonDto(person);
        personDto.setForename(person.getForename().getForename());
        personDto.setSurname(person.getSurname().getSurname());
        return personDto;
    }

    @Override
    public Person personDtoToPerson(PersonDto personDto) {
        Person person = delegate.personDtoToPerson(personDto);
        person.setForename(new Forename(personDto.getForename()));
        person.setSurname(new Surname(personDto.getSurname()));
        return person;
    }
}
