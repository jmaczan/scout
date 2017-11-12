package pl.jmaczan.scout.server.meeting.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Long> teamsInvolved = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParticipationRating> participationRatings = new ArrayList<>();

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTeamsInvolved() {
        return teamsInvolved;
    }

    public void setTeamsInvolved(List<Long> teamsInvolved) {
        this.teamsInvolved = teamsInvolved;
    }

    public List<ParticipationRating> getParticipationRatings() {
        return participationRatings;
    }

    public void setParticipationRatings(List<ParticipationRating> participationRatings) {
        this.participationRatings = participationRatings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
