package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
class Patrol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<Member, Function> members = new HashMap<Member, Function>();
}
