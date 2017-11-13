import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Team} from "../models/team";
import {Member} from "../models/member";

/*
  Generated class for the TeamRestServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class TeamRestService {

  private teamServerURL: string  = "http://localhost:8080/team";
  private getAllTeamsSuffix: string = "/all";
  private getAllTeamsAndMembersSuffix: string = "/all/member/all";
  private addTeamSuffix: string = "/add";
  private addTeamMemberSuffix: string = "/add/member";

  constructor(public http: Http) {
    console.log('Hello TeamRestService Provider');
  }

  getAllTeams() {
    const url = this.teamServerURL + this.getAllTeamsSuffix;
    return this.http.get(url);
  }

  getAllTeamsAndMembers() {
    const url = this.teamServerURL + this.getAllTeamsAndMembersSuffix;
    return this.http.get(url);
  }

  addTeam(team: Team) {
    const url = this.teamServerURL + this.addTeamSuffix;
    return this.http.post(url, team);
  }

  addTeamMember(member: Member) {
    const url = this.teamServerURL + this.addTeamMemberSuffix;
    return this.http.post(url, member);
  }

}
