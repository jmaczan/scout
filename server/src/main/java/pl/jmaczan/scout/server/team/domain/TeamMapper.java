package pl.jmaczan.scout.server.team.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;

@Mapper(componentModel="spring")
interface TeamMapper {

    TeamDto teamToTeamDto(Team team);
    Team teamDtoToTeam(TeamDto teamDto);
}
