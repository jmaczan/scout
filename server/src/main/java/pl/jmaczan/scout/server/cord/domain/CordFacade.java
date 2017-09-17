package pl.jmaczan.scout.server.cord.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.cord.domain.dto.CordDto;

import java.util.List;

@Service
public class CordFacade {

    @Autowired
    private CordService cordService;

    @Autowired
    private CordMapper mapper;

    public void addCord(CordDto cordDto) {
        Cord cord = mapper.cordDtoToCord(cordDto);
        this.cordService.addCord(cord);
    }

    public List<Cord> getAll() {
        return this.cordService.getAll();
    }

    public void removeCord(Long id) {
        this.cordService.removeCord(id);
    }

}
