package pl.jmaczan.scout.server.team.domain.dto;

public class TeamMemberWithFunctionDto {

    private TeamMemberDto teamMemberDto;
    private FunctionDto functionDto;

    public TeamMemberDto getTeamMemberDto() {
        return teamMemberDto;
    }

    public void setTeamMemberDto(TeamMemberDto teamMemberDto) {
        this.teamMemberDto = teamMemberDto;
    }

    public FunctionDto getFunctionDto() {
        return functionDto;
    }

    public void setFunctionDto(FunctionDto functionDto) {
        this.functionDto = functionDto;
    }
}
