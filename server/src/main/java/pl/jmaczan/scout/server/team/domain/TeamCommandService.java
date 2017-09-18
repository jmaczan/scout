package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.commons.exception.DataValidationException;

import java.util.List;

@Service
@Transactional
class TeamCommandService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private FunctionService functionService;

    void addTeam(Team team) {
        this.teamRepository.save(team);
    }

    void addTeamMemberWithFunction(Long teamId, TeamMember teamMember, Function function) {
        Team team = teamRepository.findOne(teamId);
        if(team == null) {
            throw new DataValidationException("There's no such team in database");
        }
        TeamMember savedTeamMember = teamMemberService.addTeamMember(teamMember);
        Function savedFunction = functionService.addFunction(function);
        team.addMember(savedTeamMember, savedFunction);
        teamRepository.save(team);
        /*
        co trzeba zrobic:
        sprawdzenie czy team istnieje
        napisanie mapera dla team member i function
        zapisanie do bazy team member i function
         */
    }

    void removeTeam(Long id) {
        this.teamRepository.delete(id);
    }

}
