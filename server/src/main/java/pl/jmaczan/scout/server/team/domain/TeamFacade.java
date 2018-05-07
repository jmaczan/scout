package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;
import pl.jmaczan.scout.server.team.domain.dto.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamFacade {

    @Autowired
    private PersonFacade personFacade;

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

    public void addMember(AddTeamMemberDto dto) {
        Long teamId = dto.getTeamId();
        Long personId = dto.getPersonId();
        TeamMemberDto teamMemberDto = new TeamMemberDto();
        teamMemberDto.setPersonId(personId);
        TeamMember teamMember = teamMemberMapper.teamMemberDtoToTeamMember(teamMemberDto);
        FunctionDto functionDto = new FunctionDto();
        functionDto.setName("Szeregowy");
        Function function = functionMapper.functionDtoToFunction(functionDto);
        teamCommandService.addTeamMemberWithFunction(teamId, teamMember, function);
    }

    public List<TeamDto> getAllTeams() {
        return teamMapper.teamsToTeamDtos(teamQueryService.getAllTeams());
    }

    public List<TeamWithMembersDto> getAllTeamsWithMembers() {
        List<TeamWithMembersDto> teams = new ArrayList<>();
        teamMapper.teamsToTeamDtos(teamQueryService.getAllTeams()).stream().forEach(team -> {
            TeamWithMembersDto temp = new TeamWithMembersDto();
            temp.setId(team.getId());
            temp.setName(team.getName());

            team.getMembers().stream().forEach(member -> {
                temp.getMembers().add(getTeamMemberDetails(team.getId(), member.getTeamMemberDto().getId()));
            });

            teams.add(temp);
        });

        return teams;
    }

    public List<TeamMemberDto> getAllMembers() {
        List<TeamMemberDto> memberDtos = new ArrayList<>();
        teamMemberService.getAllMembers().forEach(member -> {
            memberDtos.add(teamMemberMapper.teamMemberToTeamMemberDto(member));
        });
        return memberDtos;
    }

    public MemberDto getTeamMemberDetails(Long teamId, Long memberId) {
        MemberDto memberDto = new MemberDto();
        TeamMember member = teamMemberService.getMember(memberId);
        if (member != null) {
            Long personId = member.getPersonId();
            PersonDto personDto = personFacade.getPerson(personId);
            memberDto.setPersonId(personDto.getId());
            memberDto.setForename(personDto.getForename());
            memberDto.setSurname(personDto.getSurname());
            memberDto.setDescription(personDto.getDescription());
            memberDto.setHasAnchorOnScarf(member.isHasAnchorOnScarf());
            memberDto.setHasCross(member.isHasCross());
            memberDto.setHasScarf(member.isHasScarf());
            memberDto.setCordId(member.getCordId());
            memberDto.setRankId(member.getRankId());
            memberDto.setMemberId(member.getId());
        }
        return memberDto;
    }

    public void removeTeam(Long id) {
        teamCommandService.removeTeam(id);
    }

    public void removeAllTeams() {
        teamCommandService.removeAllTeams();
    }

    public void removeAllMembers() {
        teamMemberService.removeAllMembers();
    }
}
