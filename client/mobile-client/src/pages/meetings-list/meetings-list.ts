import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {Meeting} from "../../models/meeting";
import {MeetingService} from "../../providers/meeting-service";
import {MeetingDetailsPage} from "../meeting-details/meeting-details";

/**
 * Generated class for the MeetingsListPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meetings-list',
  templateUrl: 'meetings-list.html',
})
export class MeetingsListPage {

  meetings: Meeting[];
  private justStarted: boolean = true;
  private meetingsLoaded: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App, private meetingService: MeetingService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingsListPage');
    this.fetchMeetingsList().then(

    );
  }

  ionViewDidEnter() {
    if (this.justStarted) {
      this.justStarted = false;
      this.fetchMeetingsList().then(
        res => {
          console.log("Loaded meetings.");
        },
        err => {
          console.log("Failed to fetch meetings.");
        }
      ).then(
        res => {
          console.log("Loaded meetings.");
        }, err => {
          console.log("Failed to fetch meetings.");
        }
      );
    }
  }

  fetchMeetingsList() {
    return new Promise((resolve, reject) => {
      this.meetingService.getAllMeetings().subscribe(
        res => {
          this.meetings = res;
          console.log(res);
          this.meetingsLoaded = true;
        }, err => {
          this.meetings = [];
          this.meetingsLoaded = true;
        }
      );
    })
  }

  showMeetingDetails(meeting) {
    this.appCtrl.getRootNav().push(MeetingDetailsPage, {
      meeting: meeting
    });
  }

  doRefresh(refresher) {
    console.log('TeamsListPage: teams list refresh requested', refresher);
    this.fetchMeetingsList().then(refresher.complete());
  }

}
