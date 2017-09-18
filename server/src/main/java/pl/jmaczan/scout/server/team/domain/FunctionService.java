package pl.jmaczan.scout.server.team.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    Function addFunction(Function function) {
        //TODO - add checking whether such position already exists in db
        return functionRepository.save(function);
    }
}
