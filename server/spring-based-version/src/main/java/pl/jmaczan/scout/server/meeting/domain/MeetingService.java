package pl.jmaczan.scout.server.meeting.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MeetingService {

    @Autowired
    private ParticipationRatingService participationRatingService;

    @Autowired
    private ParticipationRatingRepository participationRatingRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    Meeting addMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    Meeting addMeeting(Meeting meeting, List<ParticipationRating> participationRatingList) {
        List<ParticipationRating> participationRatingsAdded = new ArrayList<>();

        participationRatingList.forEach(rating ->
                participationRatingsAdded.add(participationRatingService.addParticipationRating(rating))
        );

        meeting.setParticipationRatings(participationRatingsAdded);

        return meetingRepository.save(meeting);
    }

    List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    void removeMeeting(Long id) {
        meetingRepository.delete(id);
    }

}
