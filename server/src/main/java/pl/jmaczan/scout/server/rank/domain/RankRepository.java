package pl.jmaczan.scout.server.rank.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RankRepository extends JpaRepository<Rank, Long> {
}
