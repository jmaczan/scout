package pl.jmaczan.scout.server.cord.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CordRepository extends JpaRepository<Cord, Long>{
}
