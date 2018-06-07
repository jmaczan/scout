package pl.jmaczan.scout.server.team.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PatrolRepository extends JpaRepository<Patrol, Long> {
}
