package pl.jmaczan.scout.server.rank.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.rank.domain.dto.RankDto;
import pl.jmaczan.scout.server.rank.domain.exception.RankValueException;

@Service
public class RankFacade {

    @Autowired
    private RankService rankService;

    public void createRank(RankDto rankDto) {
        Rank rank = new Rank();
        rank.setValue(rankDto.getValue());
        this.rankService.addRank(rank);
    }

    public void removeRank(RankDto rankDto) {
        if (rankDto.getId() != null || this.rankService.getRank(rankDto.getId()) != null) {
            this.rankService.removeRank(rankDto.getId());
        } else {
            throw new RankValueException("Wrong rank id");
        }
    }
}
