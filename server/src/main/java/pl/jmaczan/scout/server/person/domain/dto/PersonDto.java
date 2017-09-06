package pl.jmaczan.scout.server.person.domain.dto;

public class PersonDto {

    private Long id;
    private String forename;
    private String surname;
    private String description;

    public PersonDto() {
    }

    public PersonDto(String forename, String surname, String description) {
        this.forename = forename;
        this.surname = surname;
        this.description = description;
    }

    public PersonDto(Long id, String forename, String surname, String description) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
