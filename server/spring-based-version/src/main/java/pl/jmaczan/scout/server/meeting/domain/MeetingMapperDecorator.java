package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;
import pl.jmaczan.scout.server.meeting.domain.dto.ParticipationRatingDto;

import java.util.ArrayList;
import java.util.List;

@Component
class MeetingMapperDecorator implements MeetingMapper {

    @Autowired
    private MeetingMapper delegate;

    @Autowired
    private ParticipationRatingMapperDecorator participationRatingMapperDecorator;

    @Override
    public MeetingDto meetingToMeetingDto(Meeting meeting) {
        List<ParticipationRatingDto> participationRatingDtos = new ArrayList<>();
        meeting.getParticipationRatings().forEach(rating -> participationRatingDtos.add(participationRatingMapperDecorator.participationRatingToParticipationRatingDto(rating)));

        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setParticipationRatings(participationRatingDtos);
        meetingDto.setDescription(meeting.getDescription());
        meetingDto.setTeamsInvolved(meeting.getTeamsInvolved());
        return meetingDto;
    }

    @Override
    public Meeting meetingDtoToMeeting(MeetingDto meetingDto) {
        List<ParticipationRating> participationRatings = new ArrayList<>();
        meetingDto.getParticipationRatings().forEach(ratingDto -> participationRatings.add(participationRatingMapperDecorator.participationRatingDtoToParticipationRating(ratingDto)));

        Meeting meeting = new Meeting();
        meeting.setId(meetingDto.getId());
        meeting.setParticipationRatings(participationRatings);
        meeting.setTeamsInvolved(meetingDto.getTeamsInvolved());
        meeting.setDescription(meetingDto.getDescription());
        if (meetingDto.getId() != null) {
            meeting.setId(meetingDto.getId());
        }
        return meeting;
    }
}
