package pl.jmaczan.scout.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

@Transactional
public class DevelopmentDataLoader implements ApplicationRunner {

    @Autowired
    private PersonFacade personFacade;

    @Override
    public void run(ApplicationArguments args) {
        PersonDto personDto = new PersonDto();
        personDto.setForename("Jan");
        personDto.setSurname("Kowalski");
        personDto.setDescription("opis");
        personDto.setId(1L);

        personFacade.addPerson(personDto);

        for(PersonDto personDto1 : personFacade.getAllPersons()) {
            System.out.println(personDto1.getId() + " " + personDto.getForename());
        }
        System.out.println("koniec");
    }

}
