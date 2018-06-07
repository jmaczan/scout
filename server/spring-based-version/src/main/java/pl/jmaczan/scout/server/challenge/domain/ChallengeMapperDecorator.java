package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.challenge.domain.dto.ChallengeDto;

import java.util.ArrayList;
import java.util.List;

@Component
class ChallengeMapperDecorator implements ChallengeMapper {

    @Autowired
    private ChallengeMapper delegate;

    @Override
    public ChallengeDto challengeToChallengeDto(Challenge challenge) {
        return this.delegate.challengeToChallengeDto(challenge);
    }

    @Override
    public Challenge challengeDtoToChallenge(ChallengeDto challengeDto) {
        return this.delegate.challengeDtoToChallenge(challengeDto);
    }

    List<ChallengeDto> challengesToChallengeDtos(List<Challenge> challengeList) {
        List<ChallengeDto> challengeDtoList = new ArrayList<>();
        challengeList.stream().forEach(challenge -> challengeDtoList.add(challengeToChallengeDto(challenge)));
        return challengeDtoList;
    }

    List<Challenge> challengeDtosToChallenges(List<ChallengeDto> challengeDtoList) {
        List<Challenge> challengeList = new ArrayList<>();
        challengeDtoList.stream().forEach(challengeDto -> challengeList.add(challengeDtoToChallenge(challengeDto)));
        return challengeList;
    }
}
