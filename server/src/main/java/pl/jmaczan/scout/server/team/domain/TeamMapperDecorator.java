package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberWithFunctionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class TeamMapperDecorator implements TeamMapper {

    @Autowired
    private TeamMapper delegate;

    @Autowired
    private TeamMemberMapperDecorator teamMemberDelegate;

    @Autowired
    private FunctionMapperDecorator functionDelegate;

    @Override
    public TeamDto teamToTeamDto(Team team) {
        //TeamDto teamDto = this.delegate.teamToTeamDto(team);
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName().getValue());
        List<TeamMemberWithFunctionDto> members = new ArrayList<>();
        team.getMembers().forEach((member, function) -> {
            TeamMemberWithFunctionDto teamMemberWithFunctionDto = new TeamMemberWithFunctionDto();
            teamMemberWithFunctionDto.setTeamMemberDto(teamMemberDelegate.teamMemberToTeamMemberDto(member));
            teamMemberWithFunctionDto.setFunctionDto(functionDelegate.functionToFunctionDto(function));
            members.add(teamMemberWithFunctionDto);
        });
        teamDto.setMembers(members);
        return teamDto;
    }

    @Override
    public Team teamDtoToTeam(TeamDto teamDto) {
        //Team team = this.delegate.teamDtoToTeam(teamDto);
        Team team = new Team();
        team.setName(new TeamName(teamDto.getName()));
        Map<TeamMember, Function> members = new HashMap<>();
        if(teamDto.getMembers() != null) {
            teamDto.getMembers().forEach(member -> {
                members.put(teamMemberDelegate.teamMemberDtoToTeamMember(member.getTeamMemberDto()),
                        functionDelegate.functionDtoToFunction(member.getFunctionDto()));
            });
        }
        team.setMembers(members);
        return team;
    }

    List<TeamDto> teamsToTeamDtos(List<Team> teamList) {
        List<TeamDto> teamDtoList = new ArrayList<>();
        teamList.stream().forEach(team -> teamDtoList.add(teamToTeamDto(team)));
        return teamDtoList;
    }

    List<Team> teamDtosToTeams(List<TeamDto> teamDtos) {
        List<Team> teamList = new ArrayList<>();
        teamDtos.stream().forEach(teamDto -> teamList.add(teamDtoToTeam(teamDto)));
        return teamList;
    }
}
