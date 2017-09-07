package pl.jmaczan.scout.server.person.domain;

import pl.jmaczan.scout.server.person.domain.exception.ValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class Surname {

    @Column(name = "SURNAME")
    private String value;

    Surname() {
    }

    Surname(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String surname) {
        if(surname == null || surname.length() == 0) {
            throw new ValidationException("Invalid surname");
        }
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surname)) return false;

        Surname surname = (Surname) o;

        return value != null ? value.equals(surname.value) : surname.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
