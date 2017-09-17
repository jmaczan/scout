package pl.jmaczan.scout.server.cord.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.cord.domain.dto.CordDto;

@Mapper(componentModel="spring")
interface CordMapper {

    CordDto cordToCordDto(Cord cord);
    Cord cordDtoToCord(CordDto cordDto);
}
