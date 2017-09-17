package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TeamCommandService {

    @Autowired
    private TeamRepository teamRepository;

    void addTeam(Team team) {
        this.teamRepository.save(team);
    }

    void removeTeam(Long id) {
        this.teamRepository.delete(id);
    }

}
