package pl.jmaczan.scout.server.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jmaczan.scout.server.meeting.domain.MeetingFacade;
import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;

import java.util.List;

@RestController
@RequestMapping("meeting")
@CrossOrigin
class MeetingEndpoint {

    @Autowired
    private MeetingFacade meetingFacade;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllMeetings() {
        List<MeetingDto> meetingDtoList = meetingFacade.getAllMeetings();
        return new ResponseEntity<>(meetingDtoList, HttpStatus.OK);
    }

    @PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addMeeting(@RequestBody MeetingDto meetingDto) {
        meetingFacade.addMeeting(meetingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> removeMeeting(@RequestBody MeetingDto meetingDto) {
        meetingFacade.removeMeeting(meetingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
