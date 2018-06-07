package pl.jmaczan.scout.server.cord.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CordService {

    @Autowired
    private CordRepository cordRepository;

    void addCord(Cord cord) {
        this.cordRepository.save(cord);
    }

    List<Cord> getAll() {
        return this.getAll();
    }

    void removeCord(Long id) {
        this.cordRepository.delete(id);
    }
}
