package pl.jmaczan.scout.server.person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@SpringBootTest
public class PersonFacadeTests {

    @Autowired
    private PersonFacade personFacade;

    @Test
    public void should_returnCorrectPerson_when_personHasBeenAdded() {
        //GIVEN
        PersonDto personDto = new PersonDto();
        personDto.setForename("Jan");
        personDto.setSurname("Kowalski");
        personDto.setDescription("opis 1");
        personFacade.addPerson(personDto);

        List<PersonDto> persons = personFacade.getAllPersons();
        //there's only one person, so we take a first
        PersonDto retrievedPerson = persons.get(0);
        //we have to assign his id if we want to modify the record
        personDto.setId(retrievedPerson.getId());

        //WHEN
        PersonDto retrievedPersonDto = personFacade.getPerson(personDto);

        //THEN
        Assert.assertNotNull(retrievedPersonDto);

        Assert.assertEquals(personDto.getForename(), retrievedPersonDto.getForename());
        Assert.assertEquals(personDto.getSurname(), retrievedPersonDto.getSurname());
        Assert.assertEquals(personDto.getDescription(), retrievedPersonDto.getDescription());
    }

    @Test
    public void should_returnModifiedPerson_when_personHasBeenModified() {
        //GIVEN
        PersonDto personDto = new PersonDto();
        personDto.setForename("Jan");
        personDto.setSurname("Kowalski");
        personDto.setDescription("opis 1");
        personFacade.addPerson(personDto);

        //WHEN
        personDto.setForename("Johny");
        personDto.setSurname("Kowalsky");
        personDto.setDescription("opis 3");

        List<PersonDto> persons = personFacade.getAllPersons();

        //there's only one person, so we take a first
        PersonDto retrievedPerson = persons.get(0);
        //we have to assign his id if we want to modify the record
        personDto.setId(retrievedPerson.getId());

        personFacade.modifyPerson(personDto);

        PersonDto retrievedPersonDto = personFacade.getPerson(personDto);

        //THEN
        Assert.assertNotNull(retrievedPersonDto);

        Assert.assertEquals(personDto.getForename(), retrievedPersonDto.getForename());
        Assert.assertEquals(personDto.getSurname(), retrievedPersonDto.getSurname());
        Assert.assertEquals(personDto.getDescription(), retrievedPersonDto.getDescription());
    }

    @Test
    public void should_returnEmptyList_when_noPersonsExist() {
        //WHEN
        List<PersonDto> retrievedPersonDtos = personFacade.getAllPersons();

        //THEN
        Assert.assertNotNull(retrievedPersonDtos);
        Assert.assertEquals(0, retrievedPersonDtos.size());
    }

    @Test
    public void should_returnAllPersonDtos_when_personsExist() {
        //GIVEN
        PersonDto firstPerson = new PersonDto();
        firstPerson.setForename("Jan");
        firstPerson.setSurname("Kowalski");
        firstPerson.setDescription("opis 1");
        personFacade.addPerson(firstPerson);


        PersonDto secondPerson = new PersonDto();
        secondPerson.setForename("Janina");
        secondPerson.setSurname("Kowalska");
        secondPerson.setDescription("opis 2");
        personFacade.addPerson(secondPerson);

        //WHEN
        List<PersonDto> retrievedPersonDtos = personFacade.getAllPersons();

        //THEN
        Assert.assertNotNull(retrievedPersonDtos);
        Assert.assertEquals(2, retrievedPersonDtos.size());

        Assert.assertEquals(firstPerson.getForename(), retrievedPersonDtos.get(0).getForename());
        Assert.assertEquals(firstPerson.getSurname(), retrievedPersonDtos.get(0).getSurname());
        Assert.assertEquals(firstPerson.getDescription(), retrievedPersonDtos.get(0).getDescription());

        Assert.assertEquals(secondPerson.getForename(), retrievedPersonDtos.get(1).getForename());
        Assert.assertEquals(secondPerson.getSurname(), retrievedPersonDtos.get(1).getSurname());
        Assert.assertEquals(secondPerson.getDescription(), retrievedPersonDtos.get(1).getDescription());
    }
}
