package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Meeting findByDescription(String description);
}
