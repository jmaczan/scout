package pl.jmaczan.scout.server.team.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.team.domain.dto.FunctionDto;

@Mapper(componentModel="spring")
interface FunctionMapper {

    Function functionDtoToFunction(FunctionDto functionDto);
    FunctionDto functionToFunctionDto(Function function);
}
