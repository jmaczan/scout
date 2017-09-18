package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.team.domain.dto.AddTeamMemberWithFunctionDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamFacade {

    @Autowired
    private TeamCommandService teamCommandService;

    @Autowired
    private TeamQueryService teamQueryService;

    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private TeamMapperDecorator teamMapper;

    @Autowired
    private TeamMemberMapperDecorator teamMemberMapper;

    @Autowired
    private FunctionMapperDecorator functionMapper;

    public void addTeam(TeamDto teamDto) {
        Team team = teamMapper.teamDtoToTeam(teamDto);
        teamCommandService.addTeam(team);
    }

    public void addMember(AddTeamMemberWithFunctionDto dto) {
        Long teamId = dto.getTeamId();
        Function function = functionMapper.functionDtoToFunction(dto.getFunctionDto());
        TeamMember teamMember = teamMemberMapper.teamMemberDtoToTeamMember(dto.getTeamMemberDto());
        teamCommandService.addTeamMemberWithFunction(teamId, teamMember, function);
    }

    public List<TeamDto> getAllTeams() {
        return teamMapper.teamsToTeamDtos(teamQueryService.getAllTeams());
    }

    public List<TeamMemberDto> getAllMembers() {
        List<TeamMemberDto> memberDtos = new ArrayList<>();
        teamMemberService.getAllMembers().forEach(member -> {
            memberDtos.add(teamMemberMapper.teamMemberToTeamMemberDto(member));
        });
        return memberDtos;
    }

    public void removeTeam(Long id) {
        teamCommandService.removeTeam(id);
    }

}
