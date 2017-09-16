package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long personId;

    private Long rankId;

    private Date joinDate;

    /**
     * Does the member has a scarf.
     */
    private boolean hasScarf;

    /**
     * Does member has an anchor on his scarf.
     */
    private boolean hasAnchorOnScarf;

    private boolean hasCross;



}
