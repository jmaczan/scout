package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PersonCrudService {

    @Autowired
    private PersonRepository personRepository;

    List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    void addPerson(Person person) {
        personRepository.save(person);
    }
}
