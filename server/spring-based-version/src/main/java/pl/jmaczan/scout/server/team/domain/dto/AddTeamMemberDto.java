package pl.jmaczan.scout.server.team.domain.dto;

public class AddTeamMemberDto {

    private Long teamId;
    private Long personId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
