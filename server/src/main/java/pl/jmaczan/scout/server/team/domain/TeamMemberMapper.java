package pl.jmaczan.scout.server.team.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDto;

@Mapper(componentModel="spring")
interface TeamMemberMapper {

    TeamMemberDto teamMemberToTeamMemberDto(TeamMember teamMember);
    TeamMember teamMemberDtoToTeamMember(TeamMemberDto teamMemberDto);
}
