package pl.jmaczan.scout.server.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PersonQueryService {

    @Autowired
    private PersonRepository personRepository;

    List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    Person getPerson(Person person) {
        Person result = personRepository.findOne(person.getId());
        return result;
    }

    Person getPerson(Long id) {
        return personRepository.findOne(id);
    }

}
