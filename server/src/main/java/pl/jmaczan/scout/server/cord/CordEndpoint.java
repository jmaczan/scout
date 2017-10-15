package pl.jmaczan.scout.server.cord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cord")
class CordEndpoint {

    @Autowired
    private CordEndpoint cordEndpoint;

    //TODO
}
