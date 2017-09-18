package pl.jmaczan.scout.server.team;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jmaczan.scout.server.commons.exception.DataValidationException;
import pl.jmaczan.scout.server.team.domain.TeamFacade;
import pl.jmaczan.scout.server.team.domain.dto.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@SpringBootTest
public class TeamFacadeTests {

    @Autowired
    private TeamFacade teamFacade;

    //TODO test z ustawianiem ID przy tworzeniu memberów

    @Test
    public void should_addTeamMemberAndSaveHisFunction_when_hisTeamExistsAndDataIsCorrect() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");
        teamFacade.addTeam(teamDto);

        Long teamDtoId = teamFacade.getAllTeams().get(0).getId();

        FunctionDto functionDto = new FunctionDto();
        functionDto.setName("Przyboczny");

        TeamMemberDto teamMemberDto = new TeamMemberDto();
        teamMemberDto.setPersonId(1L);
        teamMemberDto.setHasAnchorOnScarf(false);

        AddTeamMemberWithFunctionDto dto = new AddTeamMemberWithFunctionDto(teamMemberDto, functionDto, teamDtoId);

        //WHEN
        teamFacade.addMember(dto);

        List<TeamDto> teamsUpdated = teamFacade.getAllTeams();

        List<TeamMemberDto> teamMembersUpdated = teamFacade.getAllMembers();

        //THEN
        Assert.assertEquals(1, teamsUpdated.size());
        Assert.assertEquals(1, teamMembersUpdated.size());
        Assert.assertEquals(1, teamsUpdated.get(0).getMembers().size());
        Assert.assertEquals(functionDto.getName(),
                teamsUpdated.get(0).getMembers().get(0).getFunctionDto().getName());
        Assert.assertEquals(teamMemberDto.getPersonId(),
                teamsUpdated.get(0).getMembers().get(0).getTeamMemberDto().getPersonId());
        Assert.assertEquals(teamMemberDto.isHasAnchorOnScarf(),
                teamsUpdated.get(0).getMembers().get(0).getTeamMemberDto().isHasAnchorOnScarf());
    }

    @Test(expected = DataValidationException.class)
    public void should_notAddTeamMemberNorSaveHisFunction_when_hisTeamDoesntExists() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");
        teamFacade.addTeam(teamDto);

        Long teamDtoId = teamFacade.getAllTeams().get(0).getId();

        FunctionDto functionDto = new FunctionDto();
        functionDto.setName("Przyboczny");

        TeamMemberDto teamMemberDto = new TeamMemberDto();
        teamMemberDto.setPersonId(1L);
        teamMemberDto.setHasAnchorOnScarf(false);

        AddTeamMemberWithFunctionDto dto = new AddTeamMemberWithFunctionDto(teamMemberDto, functionDto, teamDtoId+999L);

        //WHEN
        teamFacade.addMember(dto);

        //THEN
        /*
        Throws DataValidationException.
         */
    }

    @Test
    public void should_notAddTeamMemberNorSaveHisFunction_when_hisTeamExistsButDataIsIncorrect() {

    }

    @Test
    public void should_returnSameTeamId_when_getAllTeamsInvokedMultipleTimesAndNewTeamsAdded() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");
        this.teamFacade.addTeam(teamDto);

        //WHEN

        Long teamDtoId = this.teamFacade.getAllTeams().get(0).getId();

        TeamDto teamDto2 = new TeamDto();
        teamDto2.setName("Vis Verum");
        this.teamFacade.addTeam(teamDto2);

        Long teamDtoIdAfterAddingTeamDto2 = this.teamFacade.getAllTeams().get(0).getId();

        Assert.assertEquals(teamDtoId, teamDtoIdAfterAddingTeamDto2);
    }

    @Test
    public void should_returnSameTeamId_when_getAllTeamsInvokedMultipleTimes() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");
        this.teamFacade.addTeam(teamDto);

        //WHEN && THEN
        List<TeamDto> teams = this.teamFacade.getAllTeams();
        Long id = teams.get(0).getId();
        Assert.assertEquals(1, teams.size());

        teams = this.teamFacade.getAllTeams();
        Assert.assertEquals(id, teams.get(0).getId());

        teams = this.teamFacade.getAllTeams();
        Assert.assertEquals(id, teams.get(0).getId());

        teams = this.teamFacade.getAllTeams();
        Assert.assertEquals(id, teams.get(0).getId());

        Assert.assertEquals(1, teams.size());
    }

    @Test
    public void should_notSetForcedId_when_invokedAddTeamMethodWithIdInTeamDto() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setId(18L);
        teamDto.setName("50 DSH Twierdza");

        TeamDto teamDto2 = new TeamDto();
        teamDto2.setId(999L);
        teamDto2.setName("Vis Verum");

        //WHEN
        this.teamFacade.addTeam(teamDto);
        this.teamFacade.addTeam(teamDto2);

        //THEN
        List<TeamDto> teams = this.teamFacade.getAllTeams();

        Assert.assertEquals(2, teams.size());
        Assert.assertEquals(teamDto.getName(), teams.get(0).getName());
        Assert.assertNotEquals(teamDto.getId(), teams.get(0).getId());
        Assert.assertEquals(teamDto2.getName(), teams.get(1).getName());
        Assert.assertNotEquals(teamDto2.getId(), teams.get(1).getId());
    }

    @Test
    public void should_addCorrectTeams_when_invokedAddTeamMethod() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");

        TeamDto teamDto2 = new TeamDto();
        teamDto2.setName("Vis Verum");

        //WHEN
        this.teamFacade.addTeam(teamDto);
        this.teamFacade.addTeam(teamDto2);

        //THEN
        List<TeamDto> teams = this.teamFacade.getAllTeams();

        Assert.assertEquals(2, teams.size());
        Assert.assertEquals(teamDto.getName(), teams.get(0).getName());
        Assert.assertEquals(teamDto2.getName(), teams.get(1).getName());
    }

    @Test
    public void should_addCorrectTeam_when_invokedAddTeamMethod() {
        //GIVEN
        TeamDto teamDto = new TeamDto();
        teamDto.setName("50 DSH Twierdza");

        //WHEN
        this.teamFacade.addTeam(teamDto);

        //THEN
        List<TeamDto> teams = this.teamFacade.getAllTeams();

        Assert.assertEquals(1, teams.size());
        Assert.assertEquals(teamDto.getName(), teams.get(0).getName());
    }

    @Test
    public void should_returnZeroTeam_when_noTeamsInDatabaseAndGetAllTeamsInvoked() {
        //WHEN
        List<TeamDto> teams = this.teamFacade.getAllTeams();

        //THEN
        Assert.assertEquals(0, teams.size());
    }
}
