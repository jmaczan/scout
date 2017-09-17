package pl.jmaczan.scout.server.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.jmaczan.scout.server.challenge.domain.ChallengeFacade;

@RestController("/challenge")
class ChallengeEndpoint {

    @Autowired
    private ChallengeFacade challengeFacade;

    //TODO
}
