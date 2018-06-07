package pl.jmaczan.scout.server.team.domain.dto;

public class AddTeamMemberWithFunctionDto extends TeamMemberWithFunctionDto {

    private Long teamId;

    public AddTeamMemberWithFunctionDto() {
        super();
    }

    public AddTeamMemberWithFunctionDto(Long teamId) {
        super();
        this.teamId = teamId;
    }

    public AddTeamMemberWithFunctionDto(TeamMemberDto teamMemberDto, FunctionDto functionDto, Long teamId) {
        super(teamMemberDto, functionDto);
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
