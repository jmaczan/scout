import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the MeetingRestServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class MeetingRestService {

  private meetingsServerURL: string  = "http://localhost:8080/meeting";
  private getAllMeetingsSuffix:  string = "/";

  constructor(public http: Http) {
    console.log('Hello MeetingRestServiceProvider Provider');
  }

  getAllMeetings() {
    const url = this.meetingsServerURL + this.getAllMeetingsSuffix;
    return this.http.get(url);
  }


}
