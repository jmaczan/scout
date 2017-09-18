package pl.jmaczan.scout.server.team.domain.dto;

public class TeamMemberWithFunctionDto {

    protected TeamMemberDto teamMemberDto;
    protected FunctionDto functionDto;

    public TeamMemberWithFunctionDto() {
    }

    public TeamMemberWithFunctionDto(TeamMemberDto teamMemberDto, FunctionDto functionDto) {
        this.teamMemberDto = teamMemberDto;
        this.functionDto = functionDto;
    }

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
