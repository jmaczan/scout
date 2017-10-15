package pl.jmaczan.scout.server.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jmaczan.scout.server.team.domain.TeamFacade;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("team")
@CrossOrigin
class TeamEndpoint {

    @Autowired
    private TeamFacade teamFacade;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllTeams() {
        List<TeamDto> teamDtos = teamFacade.getAllTeams();
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

}
