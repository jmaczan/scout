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

    void modifyPerson(Person personWithModifications) {
        validatePersonId(personWithModifications);
        Person personFound = personRepository.findOne(personWithModifications.getId());
        modifyPropertiesIfChanged(personFound, personWithModifications);
    }

    void removeAllPersons() {
        personRepository.deleteAll();
    }

    private Person modifyPropertiesIfChanged(Person original, Person modified) {
        Person resultPerson = original;
        if(original.getId() != modified.getId()) {
            throw new ValidationException("You can't modify person's id");
        }

        resultPerson.setId(original.getId());
        if(modified.getForename() != null && modified.getForename().getValue().length() != 0 && !(original.getForename().equals(modified.getForename()))) {
            resultPerson.setForename(modified.getForename());
        } else {
            resultPerson.setForename(original.getForename());
        }

        if(modified.getSurname() != null && modified.getSurname().getValue().length() != 0 && !(original.getSurname().equals(modified.getSurname()))) {
            resultPerson.setSurname(modified.getSurname());
        } else {
            resultPerson.setSurname(original.getSurname());
        }

        if(modified.getDescription() != null && modified.getDescription().length() != 0 && !(original.getDescription().equals(modified.getDescription()))) {
            resultPerson.setDescription(modified.getDescription());
        } else {
            resultPerson.setDescription(original.getDescription());
        }

        return resultPerson;
    }

    private void validatePersonId(Person person) {
        Person personFound = personRepository.findOne(person.getId());
        if(personFound == null) {
            throw new ValidationException("Invalid person id. Doesn't exist in database");
        }
    }

}
