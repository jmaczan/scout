package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.challenge.domain.dto.ChallengeDto;

import java.util.List;

@Service
public class ChallengeFacade {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private ChallengeMapperDecorator mapper;

    public void addChallenge(ChallengeDto challengeDto) {
        Challenge challenge = mapper.challengeDtoToChallenge(challengeDto);
        this.challengeService.createChallenge(challenge);
    }

    public List<ChallengeDto> getAllChallenges() {
        List<ChallengeDto> allChallenges = mapper.challengesToChallengeDtos(this.challengeService.getAll());
        return allChallenges;
    }

    public void removeChallenge(ChallengeDto challengeDto) {
        this.challengeService.removeChallenge(challengeDto.getId());
    }

}
