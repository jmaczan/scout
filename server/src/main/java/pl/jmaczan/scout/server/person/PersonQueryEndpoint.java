package pl.jmaczan.scout.server.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

import java.util.List;

@RestController("/person/query")
class PersonQueryEndpoint {

    @Autowired
    private PersonFacade personFacade;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personFacade.getPerson(personDto), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllPersons() {
        return new ResponseEntity<>(personFacade.getAllPersons(), HttpStatus.OK);
    }

}
