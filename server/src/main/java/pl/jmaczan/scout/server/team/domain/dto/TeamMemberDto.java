package pl.jmaczan.scout.server.team.domain.dto;

import java.util.Date;

public class TeamMemberDto {

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
}
