package pl.jmaczan.scout.server.person.domain;

import javax.persistence.*;

@Entity
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Forename forename;
    @Embedded
    private Surname surname;

    private String description;

    Person() {

    }

    Person(Forename forename, Surname surname, String description) {
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

    Forename getForename() {
        return forename;
    }
    void setForename(Forename forename) {
        this.forename = forename;
    }

    Surname getSurname() {
        return surname;
    }
    void setSurname(Surname surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
