package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TeamName name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<TeamMember, Function> teamMembers = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamName getName() {
        return name;
    }

    public void setName(TeamName name) {
        this.name = name;
    }

    public Map<TeamMember, Function> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Map<TeamMember, Function> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
