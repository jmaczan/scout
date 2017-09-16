package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.challenge.domain.dto.ChallengeDto;
import pl.jmaczan.scout.server.challenge.domain.exception.ChallengeException;

@Service
public class ChallengeFacade {

    @Autowired
    private ChallengeService challengeService;

    public void addChallenge(ChallengeDto challengeDto) {
        if(challengeDto.getId() == null || this.challengeService.get(challengeDto.getId()) == null) {
            this.challengeService.createChallenge();
        } else {
            throw new ChallengeException("Incorrect challenge id");
        }
    }

    public void removeChallenge(ChallengeDto challengeDto) {
        this.challengeService.removeChallenge(challengeDto.getId());
    }

}
