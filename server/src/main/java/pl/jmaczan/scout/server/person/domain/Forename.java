package pl.jmaczan.scout.server.person.domain;

import pl.jmaczan.scout.server.person.domain.exception.ValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class Forename {

    @Column(name = "FORENAME")
    private String forename;

    Forename() {

    }

    Forename(String forename) {
        validate(forename);
        this.forename = forename;
    }

    private void validate(String forename) {
        if(forename == null || forename.length() == 0) {
            throw new ValidationException("Invalid forename");
        }
    }

    String getForename() {
        return forename;
    }

    void setForename(String forename) {
        this.forename = forename;
    }
}
