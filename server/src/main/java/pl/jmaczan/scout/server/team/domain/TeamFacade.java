package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;
import pl.jmaczan.scout.server.team.domain.dto.AddTeamMemberWithFunctionDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDetailsDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public TeamMemberDetailsDto getTeamMemberDetails(Long teamId, Long memberId) {
        TeamMemberDetailsDto detailsDto = new TeamMemberDetailsDto();
        Optional<TeamMember> member = teamQueryService.get(teamId).getMembers().keySet().stream().filter(memberToFilter -> memberToFilter.getId().equals(memberId)).findFirst();
        if(member.isPresent()) {
            Long personId = member.get().getPersonId();
            PersonDto personDto = personFacade.getPerson(personId); //TODO rewrite it to mapper
            detailsDto.setPersonId(personDto.getId());
            detailsDto.setForename(personDto.getForename());
            detailsDto.setSurname(personDto.getSurname());
            detailsDto.setDescription(personDto.getDescription());
            detailsDto.setCordId(member.get().getCordId());
            detailsDto.setRankId(member.get().getRankId());
            detailsDto.setId(member.get().getId());
        }
        return detailsDto;
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
