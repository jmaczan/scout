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

        MeetingDto meetingDto = delegate.meetingToMeetingDto(meeting);
        meetingDto.setParticipationRatings(participationRatingDtos);
        return meetingDto;
    }

    @Override
    public Meeting meetingDtoToMeeting(MeetingDto meetingDto) {
        List<ParticipationRating> participationRatings = new ArrayList<>();
        meetingDto.getParticipationRatings().forEach(ratingDto -> participationRatings.add(participationRatingMapperDecorator.participationRatingDtoToParticipationRating(ratingDto)));

        Meeting meeting = delegate.meetingDtoToMeeting(meetingDto);
        meeting.setParticipationRatings(participationRatings);
        return meeting;
    }
}
