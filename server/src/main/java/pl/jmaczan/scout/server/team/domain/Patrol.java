package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
class Patrol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private PatrolName name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<TeamMember, Function> members = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatrolName getName() {
        return name;
    }

    public void setName(PatrolName name) {
        this.name = name;
    }

    public Map<TeamMember, Function> getMembers() {
        return members;
    }

    public void setMembers(Map<TeamMember, Function> members) {
        this.members = members;
    }
}
