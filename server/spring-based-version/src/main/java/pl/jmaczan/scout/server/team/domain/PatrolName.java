package pl.jmaczan.scout.server.team.domain;

import pl.jmaczan.scout.server.commons.exception.DataValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class PatrolName {

    @Column(name = "PATROL_NAME")
    private String value;

    public PatrolName() {
    }

    public PatrolName(String value) {
        this.value = value;
    }

    private void validate(String forename) {
        if (forename == null || forename.length() == 0) {
            throw new DataValidationException("Invalid patrol name");
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
