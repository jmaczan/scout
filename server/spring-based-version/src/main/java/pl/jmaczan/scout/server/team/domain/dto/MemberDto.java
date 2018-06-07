package pl.jmaczan.scout.server.team.domain.dto;

public class MemberDto {

    private Long teamId;

    private Long memberId;

    private Long personId;

    private Long rankId;

    private Long cordId;

    private String function;

    private String forename;

    private String surname;

    private String description;

    /**
     * Does the member has a scarf.
     */
    private boolean hasScarf;

    /**
     * Does member has an anchor on his scarf.
     */
    private boolean hasAnchorOnScarf;

    private boolean hasCross;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "MemberDto{" +
                "teamId=" + teamId +
                ", memberId=" + memberId +
                ", personId=" + personId +
                ", rankId=" + rankId +
                ", cordId=" + cordId +
                ", function='" + function + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", description='" + description + '\'' +
                ", hasScarf=" + hasScarf +
                ", hasAnchorOnScarf=" + hasAnchorOnScarf +
                ", hasCross=" + hasCross +
                '}';
    }
}
