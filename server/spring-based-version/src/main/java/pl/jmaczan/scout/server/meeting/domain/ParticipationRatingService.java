package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ParticipationRatingService {

    @Autowired
    private ParticipationRatingRepository participationRatingRepository;

    ParticipationRating addParticipationRating(ParticipationRating participationRating) {
        return participationRatingRepository.save(participationRating);
    }

    List<ParticipationRating> getAllRatings() {
        return participationRatingRepository.findAll();
    }

    void removeRating(Long id) {
        participationRatingRepository.delete(id);
    }
}
