package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    TeamMember addTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    List<TeamMember> getAllMembers() {
        return teamMemberRepository.findAll();
    }

    void removeTeamMember(Long id) {
        teamMemberRepository.delete(id);
    }

    void removeTeamMember(TeamMember teamMember) {
        teamMemberRepository.delete(teamMember);
    }
}
