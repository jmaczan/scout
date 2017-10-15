import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class MemberRestService {

  private teamServerURL: string  = "http://localhost:8080/team";
  private getMemberDetailsSuffix: string = "/member";
  private getAllMembersDetailsSuffix: string = "/member/all";

  constructor(public http: Http) {
    console.log('Hello MemberRestService Provider');
  }

  getAllMembersDetails(teamId: number) {
    const url = this.teamServerURL + "/" + teamId + this.getAllMembersDetailsSuffix;
    return this.http.get(url);
  }

  getMemberDetails(teamId: number, memberId: number) {
    const url = this.teamServerURL + "/" + teamId + this.getMemberDetailsSuffix + "/" + memberId;
    return this.http.get(url);
  }

}
