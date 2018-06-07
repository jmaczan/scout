package pl.jmaczan.scout.server.team.domain;

import pl.jmaczan.scout.server.commons.exception.DataValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class TeamName {

    @Column(name = "TEAM_NAME")
    private String value;

    public TeamName() {
    }

    public TeamName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String forename) {
        if (forename == null || forename.length() == 0) {
            throw new DataValidationException("Invalid team name");
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamName)) return false;

        TeamName teamName = (TeamName) o;

        return value != null ? value.equals(teamName.value) : teamName.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TeamName{" +
                "value='" + value + '\'' +
                '}';
    }
}
