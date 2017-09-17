package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TeamQueryService {

    @Autowired
    private TeamRepository teamRepository;

    Team get(Long id) {
        return this.teamRepository.findOne(id);
    }

    List<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }
}
