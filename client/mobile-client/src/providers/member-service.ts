import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Observable";
import {TeamMemberDetails} from "../models/team-member-details";
import {MemberRestService} from "./member-rest-service";

/*
  Generated class for the MemberServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class MemberService {

  constructor(public http: Http, private memberRestService: MemberRestService) {
    console.log('Hello MemberService Provider');
  }

  getAllMemberDetailsFromTeam(teamId: number) : Observable<TeamMemberDetails[]> {
    return this.memberRestService.getAllMembersDetails(teamId).map(
      response => {
        let responseObjects: Object[] = <Object[]> response.json();
        let details: TeamMemberDetails[] = [];

        responseObjects.forEach(object => {
          details.push(Object.assign(new TeamMemberDetails(), object));
        });

        return details;
      },
      error => {
        console.error("Failed to load all members details from team " + teamId);
        return [];
      }
    );
  }

  getMemberDetails(teamId: number, memberId: number) : Observable<TeamMemberDetails> {
    return this.memberRestService.getMemberDetails(teamId, memberId).map(
      response => {
        let responseObject: Object = <Object> response.json();
        let details: TeamMemberDetails = Object.assign(new TeamMemberDetails(), responseObject);

        return details;
      },
      error => {
        console.error("Failed to load teams.");
        return [];
      }
    );
  }

}
