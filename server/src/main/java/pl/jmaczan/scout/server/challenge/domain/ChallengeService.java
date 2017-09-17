package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    void createChallenge(Challenge challenge) {
        this.challengeRepository.save(challenge);
    }

    Challenge get(Long id) {
        return this.challengeRepository.findOne(id);
    }

    List<Challenge> getAll() {
        return this.challengeRepository.findAll();
    }

    void removeChallenge(Long id) {
        this.challengeRepository.delete(id);
    }

    void removeChallenge(Challenge challenge) {
        this.challengeRepository.delete(challenge.getId());
    }
}
