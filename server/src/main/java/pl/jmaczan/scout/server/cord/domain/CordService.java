package pl.jmaczan.scout.server.cord.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CordService {

    @Autowired
    private CordRepository cordRepository;

    void addCord(Cord cord) {
        this.cordRepository.save(cord);
    }
}
