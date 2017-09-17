package pl.jmaczan.scout.server.team.domain.dto;

import java.util.List;

public class TeamDto {

    private Long id;
    private String name;
    private List<TeamMemberWithFunctionDto> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeamMemberWithFunctionDto> getMembers() {
        return members;
    }

    public void setMembers(List<TeamMemberWithFunctionDto> members) {
        this.members = members;
    }
}
