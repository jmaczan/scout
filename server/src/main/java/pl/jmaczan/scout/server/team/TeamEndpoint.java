package pl.jmaczan.scout.server.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jmaczan.scout.server.team.domain.TeamFacade;
import pl.jmaczan.scout.server.team.domain.dto.AddTeamMemberDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamWithMembersDto;

import java.util.List;

@RestController
@RequestMapping("team")
@CrossOrigin
class TeamEndpoint {

    @Autowired
    private TeamFacade teamFacade;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllTeams() {
        List<TeamDto> teamDtos = teamFacade.getAllTeams();
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/all/member/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllTeamsWithMembers() {
        List<TeamWithMembersDto> teamDtos = teamFacade.getAllTeamsWithMembers();
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{teamId}/member/{memberId}")
    ResponseEntity<?> getTeamMemberDetails(@PathVariable("teamId") Long teamId, @PathVariable("memberId") Long memberId) {
        return new ResponseEntity<>(teamFacade.getTeamMemberDetails(teamId, memberId), HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addTeam(@RequestBody TeamDto teamDto) {
        teamFacade.addTeam(teamDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add/member", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addTeamMember(@RequestBody AddTeamMemberDto addTeamMemberDto) {
        teamFacade.addMember(addTeamMemberDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
