package pl.jmaczan.scout.server.team.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long personId;

    private Long rankId;

    private Long cordId;

    /**
     * Does the member has a scarf.
     */
    private boolean hasScarf;

    /**
     * Does member has an anchor on his scarf.
     */
    private boolean hasAnchorOnScarf;

    private boolean hasCross;

    private ArrayList<Long> challenges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Long getCordId() {
        return cordId;
    }

    public void setCordId(Long cordId) {
        this.cordId = cordId;
    }

    public boolean isHasScarf() {
        return hasScarf;
    }

    public void setHasScarf(boolean hasScarf) {
        this.hasScarf = hasScarf;
    }

    public boolean isHasAnchorOnScarf() {
        return hasAnchorOnScarf;
    }

    public void setHasAnchorOnScarf(boolean hasAnchorOnScarf) {
        this.hasAnchorOnScarf = hasAnchorOnScarf;
    }

    public boolean isHasCross() {
        return hasCross;
    }

    public void setHasCross(boolean hasCross) {
        this.hasCross = hasCross;
    }

    public List<Long> getChallenges() {
        return challenges;
    }

    public void setChallenges(ArrayList<Long> challenges) {
        this.challenges = challenges;
    }
}
