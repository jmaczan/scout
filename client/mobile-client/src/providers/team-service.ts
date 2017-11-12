import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

import { TeamRestService } from '../providers/team-rest-service';
import { Team } from '../models/team';
import {Observable} from "rxjs/Observable";
import {Member} from "../models/member";

@Injectable()
export class TeamService {

  teams: Team[] = null;

  constructor(private http: Http, private teamRestService: TeamRestService) {

  }

  getAllTeamsAndMembers() : Observable<Team[]> {
    return this.teamRestService.getAllTeamsAndMembers().map(
      response => {
        let responseObjects: Object[] = <Object[]> response.json();
        let teams: Team[] = [];

        responseObjects.forEach(object => {
          teams.push(Object.assign(new Team(), object));
        });

        this.teams = teams;

        return teams;
      },
      error => {
        console.error("Failed to load teams.");
        return [];
      }
    );
  }

  getAllTeams() : Observable<Team[]> {
    return this.teamRestService.getAllTeams().map(
      response => {
        let responseObjects: Object[] = <Object[]> response.json();
        let teams: Team[] = [];

        responseObjects.forEach(object => {
          teams.push(Object.assign(new Team(), object));
        });

        this.teams = teams;

        return teams;
      },
      error => {
        console.error("Failed to load teams.");
        return [];
      }
    );
  }

  addTeam(team: Team) {
    return this.teamRestService.addTeam(team).subscribe();
  }

  addTeamMember(member: Member) {
    return this.teamRestService.addTeamMember(member).subscribe();
  }

}
