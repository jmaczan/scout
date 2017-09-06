package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.person.domain.exception.ValidationException;

@Service
class PersonCommandService {

    @Autowired
    private PersonRepository personRepository;

    void addPerson(Person person) {
        personRepository.save(person);
    }

    void modifyPerson(Person person) {
        validatePersonId(person);
        personRepository.findOne(person.getId());
    }

    private void validatePersonId(Person person) {
        Person personFound = personRepository.findOne(person.getId());
        if(personFound == null) {
            throw new ValidationException("Invalid person id");
        }
    }

}
