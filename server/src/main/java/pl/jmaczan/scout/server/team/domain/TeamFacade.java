package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;

import java.util.List;

@Service
public class TeamFacade {

    @Autowired
    private TeamCommandService teamCommandService;

    @Autowired
    private TeamQueryService teamQueryService;

    @Autowired
    private TeamMapperDecorator mapper;

    public void addTeam(TeamDto teamDto) {
        Team team = mapper.teamDtoToTeam(teamDto);
        this.teamCommandService.addTeam(team);
    }

    public List<TeamDto> getAllTeams() {
        return mapper.teamsToTeamDtos(this.teamQueryService.getAllTeams());
    }

    public void removeTeam(Long id) {
        this.teamCommandService.removeTeam(id);
    }

}
