package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDto;

@Component
class TeamMemberMapperDecorator implements TeamMemberMapper {

    @Autowired
    private TeamMemberMapper delegate;

    @Override
    public TeamMemberDto teamMemberToTeamMemberDto(TeamMember teamMember) {
        TeamMemberDto teamMemberDto = this.delegate.teamMemberToTeamMemberDto(teamMember);
        return teamMemberDto;
    }

    @Override
    public TeamMember teamMemberDtoToTeamMember(TeamMemberDto teamMemberDto) {
        return this.delegate.teamMemberDtoToTeamMember(teamMemberDto);
    }
}
