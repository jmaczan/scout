package pl.jmaczan.scout.server.challenge.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ChallengeRepository extends JpaRepository<Challenge, Long>{
}
