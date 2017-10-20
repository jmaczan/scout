package pl.jmaczan.scout.server.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;

@RestController
@RequestMapping("/person/command")
@CrossOrigin
public class PersonCommandEndpoint {

    @Autowired
    private PersonFacade personFacade;

    @PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addPerson(@RequestBody PersonDto personDto) {
        personFacade.addPerson(personDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> modifyPerson(@RequestBody PersonDto personDto) {
        personFacade.modifyPerson(personDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
