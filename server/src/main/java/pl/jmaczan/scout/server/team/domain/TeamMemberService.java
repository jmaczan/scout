package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;
}
