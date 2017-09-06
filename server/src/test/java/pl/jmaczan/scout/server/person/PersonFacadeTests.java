package pl.jmaczan.scout.server.person;

import org.junit.Assert;
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
