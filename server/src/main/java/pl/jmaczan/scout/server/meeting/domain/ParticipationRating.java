package pl.jmaczan.scout.server.meeting.domain;

import javax.persistence.*;

/**
 * OPMAZ
 */
@Entity
class ParticipationRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "RATING_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long teamMemberId;

    @Column(name = "PRESENCE")
    private Integer presence;

    @Column(name = "PUNCTUALITY")
    private Integer punctuality;

    @Column(name = "UNIFORM")
    private Integer uniform;

    @Column(name = "ACTIVITY")
    private Integer activity;

    @Column(name = "BEHAVIOR")
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
