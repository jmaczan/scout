package pl.jmaczan.scout.server.challenge.domain;

import org.mapstruct.Mapper;
import pl.jmaczan.scout.server.challenge.domain.dto.ChallengeDto;

@Mapper(componentModel="spring")
interface ChallengeMapper {

    ChallengeDto challengeToChallengeDto(Challenge challenge);
    Challenge challengeDtoToChallenge(ChallengeDto challengeDto);
}
