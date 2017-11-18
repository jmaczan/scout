package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingFacade {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private ParticipationRatingService participationRatingService;

    @Autowired
    private MeetingMapperDecorator meetingMapper;

    public void addMeeting(MeetingDto meetingDto) {
        Meeting meeting = meetingMapper.meetingDtoToMeeting(meetingDto);
        meetingService.addMeeting(meeting, meeting.getParticipationRatings());
    }

    public void removeMeeting(MeetingDto meetingDto) {
        Meeting meeting = meetingMapper.meetingDtoToMeeting(meetingDto);
        meetingService.removeMeeting(meeting.getId());
    }

    public List<MeetingDto> getAllMeetings() {
        List<MeetingDto> allMeetings = new ArrayList<>();
        meetingService.getAllMeetings().forEach(meeting -> allMeetings.add(meetingMapper.meetingToMeetingDto(meeting)));
        return allMeetings;
    }


}
