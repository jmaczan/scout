import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {ParticipationRating} from "../../models/participation-rating";
import {MeetingRateActivityPage} from "../meeting-rate-activity/meeting-rate-activity";

/**
 * Generated class for the MeetingRateUniformPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-rate-uniform',
  templateUrl: 'meeting-rate-uniform.html',
})
export class MeetingRateUniformPage {

  participantsWithRatings: any[] = [];
  chosenTeams: number[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.participantsWithRatings = navParams.get("participantsWithRatings");
    this.chosenTeams = navParams.get("chosenTeams");

    console.log(this.participantsWithRatings.length);
    console.log(this.participantsWithRatings[0].member.forename);
  }
  next(event) {
    this.appCtrl.getRootNav().push(MeetingRateActivityPage, {participantsWithRatings: this.participantsWithRatings, chosenTeams: this.chosenTeams });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRateUniformPage');
  }

}
