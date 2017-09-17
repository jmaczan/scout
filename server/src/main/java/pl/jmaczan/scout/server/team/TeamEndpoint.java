package pl.jmaczan.scout.server.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.jmaczan.scout.server.team.domain.TeamFacade;

@RestController("/team")
class TeamEndpoint {

    @Autowired
    private TeamFacade teamFacade;
}
