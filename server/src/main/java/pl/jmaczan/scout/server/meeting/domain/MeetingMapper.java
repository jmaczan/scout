package pl.jmaczan.scout.server.meeting.domain;

import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;

interface MeetingMapper {

    MeetingDto meetingToMeetingDto(Meeting meeting);

    Meeting meetingDtoToMeeting(MeetingDto meetingDto);
}
