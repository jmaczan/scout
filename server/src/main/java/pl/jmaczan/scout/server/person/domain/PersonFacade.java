package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.List;

@Service
public class PersonFacade {

    @Autowired
    private PersonCommandService personCommandService;

    @Autowired
    private PersonQueryService personQueryService;

    @Autowired
    private PersonMapperDecorator mapper;

    public void addPerson(PersonDto personDto) {
        Person person = mapper.personDtoToPerson(personDto);
        personCommandService.addPerson(person);
    }

    public void modifyPerson(PersonDto personDto) {
        Person person = mapper.personDtoToPerson(personDto);
        personCommandService.modifyPerson(person);
    }

    public PersonDto getPerson(PersonDto personDto) {
        Person person = mapper.personDtoToPerson(personDto);
        return mapper.personToPersonDto(personQueryService.getPerson(person));
    }

    public List<PersonDto> getAllPersons() {
        return mapper.personsToPersonDtos(personQueryService.getAllPersons());
    }

    public void removeAllPersons() {
        personCommandService.removeAllPersons();
    }
}
