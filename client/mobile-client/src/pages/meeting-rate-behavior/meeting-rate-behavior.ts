import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {MeetingRateActivityPage} from "../meeting-rate-activity/meeting-rate-activity";
import {MeetingService} from "../../providers/meeting-service";
import {Meeting} from "../../models/meeting";
import {MeetingAddDescriptionPage} from "../meeting-add-description/meeting-add-description";

/**
 * Generated class for the MeetingRateBehaviorPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-rate-behavior',
  templateUrl: 'meeting-rate-behavior.html',
})
export class MeetingRateBehaviorPage {

  participantsWithRatings: any[] = [];
  chosenTeams: number[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App, private meetingService: MeetingService) {
    this.participantsWithRatings = navParams.get("participantsWithRatings");
    this.chosenTeams = navParams.get("chosenTeams");
    console.log(this.participantsWithRatings.length);
    console.log(this.participantsWithRatings[0].member.forename);
  }

  next(event) {
    this.appCtrl.getRootNav().push(MeetingAddDescriptionPage, {participantsWithRatings: this.participantsWithRatings, chosenTeams: this.chosenTeams });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRateBehaviorPage');
  }

}
