package pl.jmaczan.scout.server.meeting.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class MeetingDto {

    private Long id;

    private List<Long> teamsInvolved = new ArrayList<>();

    private List<ParticipationRatingDto> participationRatings = new ArrayList<>();

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTeamsInvolved() {
        return teamsInvolved;
    }

    public void setTeamsInvolved(List<Long> teamsInvolved) {
        this.teamsInvolved = teamsInvolved;
    }

    public List<ParticipationRatingDto> getParticipationRatings() {
        return participationRatings;
    }

    public void setParticipationRatings(List<ParticipationRatingDto> participationRatings) {
        this.participationRatings = participationRatings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
