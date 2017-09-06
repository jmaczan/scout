package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonFacade {

    @Autowired
    private PersonCrudService personCrudService;

    @Autowired
    private PersonMapperDecorator personMapper;

    public void addPerson(PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);
        this.personCrudService.addPerson(person);
    }

    public void modifyPerson(PersonDto personDto) {
        //method stub; TODO
    }

    public PersonDto getPerson(PersonDto personDto) {
        return null; //method stub; TODO
    }

    public List<PersonDto> getAllPersons() {
        return personsToPersonDtos(this.personCrudService.getAllPersons());
    }

    private PersonDto personToPersonDto(Person person) {
        return personMapper.personToPersonDto(person);
    }

    private Person personDtoToPerson(PersonDto personDto) {
        return personMapper.personDtoToPerson(personDto);
    }

    private List<PersonDto> personsToPersonDtos(List<Person> personList) {
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.stream().forEach(person -> personDtoList.add(personMapper.personToPersonDto(person)));
        return personDtoList;
    }

    private List<Person> personDtosToPersonList(List<PersonDto> personDtoList) {
        List<Person> personList = new ArrayList<>();
        personDtoList.stream().forEach(personDto -> personList.add(personMapper.personDtoToPerson(personDto)));
        return personList;
    }
}
