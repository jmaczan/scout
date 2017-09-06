package pl.jmaczan.scout.server.person.domain;

import pl.jmaczan.scout.server.person.domain.exception.ValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class Surname {

    @Column(name = "SURNAME")
    private String surname;

    Surname() {
    }

    Surname(String surname) {
        validate(surname);
        this.surname = surname;
    }

    private void validate(String surname) {
        if(surname == null || surname.length() == 0) {
            throw new ValidationException("Invalid surname");
        }
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }
}
