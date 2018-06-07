package pl.jmaczan.scout.server.rank.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RankService {

    @Autowired
    private RankRepository rankRepository;

    void addRank(Rank rank) {
        this.rankRepository.save(rank);
    }

    Rank getRank(Long id) {
        return this.rankRepository.findOne(id);
    }

    void removeRank(Long id) {
        this.rankRepository.delete(id);
    }
}
