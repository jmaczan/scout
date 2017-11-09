import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

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

}
