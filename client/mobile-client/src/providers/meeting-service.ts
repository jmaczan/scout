import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Meeting} from "../models/meeting";
import {Observable} from "rxjs/Observable";
import {MeetingRestService} from "./meeting-rest-service";

/*
  Generated class for the MeetingServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class MeetingService {

  meetings: Meeting[] = null;

  constructor(public http: Http, private meetingRestService: MeetingRestService) {
    console.log('Hello MeetingServiceProvider Provider');
  }

  getAllMeetings() : Observable<Meeting[]> {
    return this.meetingRestService.getAllMeetings().map(
      response => {
        let responseObjects: Object[] = <Object[]> response.json();
        let meetings: Meeting[] = [];

        responseObjects.forEach(object => {
          meetings.push(Object.assign(new Meeting(), object));
        });

        this.meetings = meetings;

        return meetings;
      },
      error => {
        console.error("Failed to load meetings.");
        return [];
      }
    );
  }

}
