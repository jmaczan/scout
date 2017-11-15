package pl.jmaczan.scout.server.meeting.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;
import pl.jmaczan.scout.server.meeting.domain.dto.ParticipationRatingDto;

//@Mapper(componentModel="spring")
interface MeetingMapper {

    MeetingDto meetingToMeetingDto(Meeting meeting);
    Meeting meetingDtoToMeeting(MeetingDto meetingDto);
}
