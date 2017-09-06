package pl.jmaczan.scout.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.person.domain.PersonFacade;

@Transactional
public class DevelopmentDataLoader implements ApplicationRunner {

    @Autowired
    private PersonFacade personFacade;

    @Override
    public void run(ApplicationArguments args) {

    }

}
