import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

import { TeamRestService } from '../providers/team-rest-service';
import { Team } from '../models/team';
import {Observable} from "rxjs/Observable";

@Injectable()
export class TeamService {

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

        return teams;
      },
      error => {
        console.error("Failed to load teams.");
        return [];
      }
    );
  }


}
