package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    void createChallenge(Challenge challenge) {
        this.challengeRepository.save(challenge);
    }

    Challenge get(Long id) {
        this.challengeRepository.findOne(id);
    }

    void removeChallenge(Long id) {
        this.challengeRepository.delete(id);
    }

    void removeChallenge(Challenge challenge) {
        this.challengeRepository.delete(challenge.getId());
    }
}
