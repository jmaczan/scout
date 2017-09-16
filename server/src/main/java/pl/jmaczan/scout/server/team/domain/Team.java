package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.List;

@Entity
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TeamName name;

    @OneToMany
    private List<Member> members;

}
