package pl.jmaczan.scout.server.team.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamMember)) return false;

        TeamMember that = (TeamMember) o;

        if (hasScarf != that.hasScarf) return false;
        if (hasAnchorOnScarf != that.hasAnchorOnScarf) return false;
        if (hasCross != that.hasCross) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (rankId != null ? !rankId.equals(that.rankId) : that.rankId != null) return false;
        return cordId != null ? cordId.equals(that.cordId) : that.cordId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (rankId != null ? rankId.hashCode() : 0);
        result = 31 * result + (cordId != null ? cordId.hashCode() : 0);
        result = 31 * result + (hasScarf ? 1 : 0);
        result = 31 * result + (hasAnchorOnScarf ? 1 : 0);
        result = 31 * result + (hasCross ? 1 : 0);
        return result;
    }
}
