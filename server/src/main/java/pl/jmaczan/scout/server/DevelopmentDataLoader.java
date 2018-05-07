package pl.jmaczan.scout.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.meeting.domain.MeetingFacade;
import pl.jmaczan.scout.server.meeting.domain.dto.MeetingDto;
import pl.jmaczan.scout.server.meeting.domain.dto.ParticipationRatingDto;
import pl.jmaczan.scout.server.person.domain.PersonFacade;
import pl.jmaczan.scout.server.person.domain.dto.PersonDto;
import pl.jmaczan.scout.server.team.domain.TeamFacade;
import pl.jmaczan.scout.server.team.domain.dto.AddTeamMemberWithFunctionDto;
import pl.jmaczan.scout.server.team.domain.dto.FunctionDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamDto;
import pl.jmaczan.scout.server.team.domain.dto.TeamMemberDto;

import java.util.ArrayList;
import java.util.List;

@Transactional
class DevelopmentDataLoader implements ApplicationRunner {

    @Autowired
    private PersonFacade personFacade;

    @Autowired
    private TeamFacade teamFacade;

    @Autowired
    private MeetingFacade meetingFacade;

    @Override
    public void run(ApplicationArguments args) {
        PersonDto personDto = new PersonDto();
        personDto.setForename("John");
        personDto.setSurname("Doe");
        personDto.setDescription("He's a guy");

        personFacade.addPerson(personDto);

        Long personId = null;

        for (PersonDto dto : personFacade.getAllPersons()) {
            personId = dto.getId();
        }

        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH");

        TeamDto teamDto2 = new TeamDto();
        teamDto2.setName("69 DW");
        teamFacade.addTeam(teamDto);
        teamFacade.addTeam(teamDto2);

        Long teamId = null;

        List<TeamDto> allTeams = teamFacade.getAllTeams();

        for (TeamDto dto : allTeams) {
            teamId = dto.getId();
        }

        TeamMemberDto teamMemberDto = new TeamMemberDto();
        teamMemberDto.setPersonId(personId);
        teamMemberDto.setHasScarf(true);
        teamMemberDto.setHasCross(true);

        FunctionDto functionDto = new FunctionDto();
        functionDto.setName("Przyboczny");

        AddTeamMemberWithFunctionDto addTeamMemberWithFunctionDto = new AddTeamMemberWithFunctionDto();
        addTeamMemberWithFunctionDto.setTeamId(teamId);
        addTeamMemberWithFunctionDto.setTeamMemberDto(teamMemberDto);
        addTeamMemberWithFunctionDto.setFunctionDto(functionDto);

        teamFacade.addMember(addTeamMemberWithFunctionDto);

        Long memberId = teamFacade.getAllTeamsWithMembers().get(1).getMembers().get(0).getMemberId();

        List<Long> teamsInvolved = new ArrayList<>();
        teamsInvolved.add(allTeams.get(0).getId());
        teamsInvolved.add(allTeams.get(1).getId());

        ParticipationRatingDto ratingDto1 = new ParticipationRatingDto();
        ratingDto1.setTeamMemberId(memberId);
        ratingDto1.setActivity(2);
        ratingDto1.setBehavior(0);
        ratingDto1.setPresence(1);
        ratingDto1.setPunctuality(-1);
        ratingDto1.setUniform(-2);

        List<ParticipationRatingDto> participationRatingDtos = new ArrayList<>();
        participationRatingDtos.add(ratingDto1);

        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setTeamsInvolved(teamsInvolved);
        meetingDto.setDescription("Good meeting!");
        meetingDto.setParticipationRatings(participationRatingDtos);

        meetingFacade.addMeeting(meetingDto);
    }

}
