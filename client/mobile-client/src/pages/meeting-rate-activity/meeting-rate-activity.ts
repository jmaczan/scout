import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {MeetingRateBehaviorPage} from "../meeting-rate-behavior/meeting-rate-behavior";

/**
 * Generated class for the MeetingRateActivityPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-rate-activity',
  templateUrl: 'meeting-rate-activity.html',
})
export class MeetingRateActivityPage {

  participantsWithRatings: any[] = [];
  chosenTeams: number[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.participantsWithRatings = navParams.get("participantsWithRatings");
    this.chosenTeams = navParams.get("chosenTeams");
    console.log(this.participantsWithRatings.length);
    console.log(this.participantsWithRatings[0].member.forename);
  }
  next(event) {
    this.appCtrl.getRootNav().push(MeetingRateBehaviorPage, {participantsWithRatings: this.participantsWithRatings, chosenTeams: this.chosenTeams});
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRateActivityPage');
  }

}
