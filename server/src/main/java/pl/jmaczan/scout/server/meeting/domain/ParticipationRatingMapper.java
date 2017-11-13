package pl.jmaczan.scout.server.meeting.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.meeting.domain.dto.ParticipationRatingDto;

@Mapper(componentModel="spring")
interface ParticipationRatingMapper {

    ParticipationRatingDto participationRatingToParticipationRatingDto(ParticipationRating participationRating);
    ParticipationRating participationRatingDtoToParticipationRating(ParticipationRatingDto participationRatingDto);
}
