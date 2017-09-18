package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TeamName name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<TeamMember, Function> members = new HashMap<>();

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

    public void addMember(TeamMember teamMember, Function function) {
        this.members.put(teamMember, function);
    }

    public Map<TeamMember, Function> getMembers() {
        return members;
    }

    public void setMembers(Map<TeamMember, Function> members) {
        this.members = members;
    }
}
