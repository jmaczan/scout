package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jmaczan.scout.server.meeting.domain.dto.ParticipationRatingDto;

@Component
class ParticipationRatingMapperDecorator implements ParticipationRatingMapper {

    @Autowired
    private ParticipationRatingMapper delegate;

    @Override
    public ParticipationRatingDto participationRatingToParticipationRatingDto(ParticipationRating participationRating) {
        return this.delegate.participationRatingToParticipationRatingDto(participationRating);
    }

    @Override
    public ParticipationRating participationRatingDtoToParticipationRating(ParticipationRatingDto participationRatingDto) {
        return this.delegate.participationRatingDtoToParticipationRating(participationRatingDto);
    }

}
