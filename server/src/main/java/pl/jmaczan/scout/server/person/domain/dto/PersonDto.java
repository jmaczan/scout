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

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto)) return false;

        PersonDto personDto = (PersonDto) o;

        if (id != null ? !id.equals(personDto.id) : personDto.id != null) return false;
        if (forename != null ? !forename.equals(personDto.forename) : personDto.forename != null) return false;
        if (surname != null ? !surname.equals(personDto.surname) : personDto.surname != null) return false;
        return description != null ? description.equals(personDto.description) : personDto.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
