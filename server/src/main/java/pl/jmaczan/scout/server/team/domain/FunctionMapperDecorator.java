package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.team.domain.dto.FunctionDto;

@Component
class FunctionMapperDecorator implements FunctionMapper {

    @Autowired
    private FunctionMapper delegate;

    @Override
    public Function functionDtoToFunction(FunctionDto functionDto) {
        return this.delegate.functionDtoToFunction(functionDto);
    }

    @Override
    public FunctionDto functionToFunctionDto(Function function) {
        return this.delegate.functionToFunctionDto(function);
    }
}
