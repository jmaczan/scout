package pl.jmaczan.scout.server.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.List;

@RestController("/person")
class PersonCrudEndpoint {

    @Autowired
    private PersonFacade personFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<PersonDto> getAllPersons() {
        return personFacade.getAllPersons();
    }
}
