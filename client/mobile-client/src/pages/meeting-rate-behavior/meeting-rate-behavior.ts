import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {MeetingRateActivityPage} from "../meeting-rate-activity/meeting-rate-activity";

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

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.participantsWithRatings = navParams.get("participantsWithRatings");
    console.log(this.participantsWithRatings.length);
    console.log(this.participantsWithRatings[0].member.forename);
  }
  send(event) {
    //TODO: make http post/put
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRateBehaviorPage');
  }

}
