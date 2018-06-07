package pl.jmaczan.scout.server.meeting.domain.dto;

public class ParticipationRatingDto {

    private Long id;

    private Long teamMemberId;

    private Integer presence;

    private Integer punctuality;

    private Integer uniform;

    private Integer activity;

    private Integer behavior;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public Integer getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
    }

    public Integer getUniform() {
        return uniform;
    }

    public void setUniform(Integer uniform) {
        this.uniform = uniform;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }
}
