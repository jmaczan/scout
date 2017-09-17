package pl.jmaczan.scout.server.cord.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.cord.domain.dto.CordDto;

@Component
class CordMapperDecorator implements CordMapper {

    @Autowired
    private CordMapper delegate;

    @Override
    public CordDto cordToCordDto(Cord cord) {
        return this.delegate.cordToCordDto(cord);
    }

    @Override
    public Cord cordDtoToCord(CordDto cordDto) {
        return this.delegate.cordDtoToCord(cordDto);
    }
}
