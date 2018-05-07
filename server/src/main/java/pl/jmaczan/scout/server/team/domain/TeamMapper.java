package pl.jmaczan.scout.server.team.domain;

import pl.jmaczan.scout.server.team.domain.dto.TeamDto;

interface TeamMapper {

    TeamDto teamToTeamDto(Team team);

    Team teamDtoToTeam(TeamDto teamDto);
}
