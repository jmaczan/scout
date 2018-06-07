package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ParticipationRatingRepository extends JpaRepository<ParticipationRating, Long> {
}
