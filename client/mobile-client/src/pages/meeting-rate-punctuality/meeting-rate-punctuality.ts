import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Member} from "../../models/member";
import {ParticipationRating} from "../../models/participation-rating";
import {MeetingRateUniformPage} from "../meeting-rate-uniform/meeting-rate-uniform";

/**
 * Generated class for the MeetingRatePunctualityPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-rate-punctuality',
  templateUrl: 'meeting-rate-punctuality.html',
})
export class MeetingRatePunctualityPage {

  participantsWithRatings: any[] = [];
  chosenTeams: number[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    let chosenMembers = navParams.get("chosenMembers");
    this.chosenTeams = navParams.get("chosenTeams");
    chosenMembers.forEach(chosenMember => {
      this.participantsWithRatings.push({member: chosenMember.member, rating: new ParticipationRating()});
    });
    console.log(this.participantsWithRatings.length);
    console.log(this.participantsWithRatings[0].member.forename);
  }
  next(event) {
    this.appCtrl.getRootNav().push(MeetingRateUniformPage, {participantsWithRatings: this.participantsWithRatings, chosenTeams: this.chosenTeams });
  }

  logEvent(event) {
    console.log(this.participantsWithRatings[0].rating.punctuality);
    if(this.participantsWithRatings.length > 1) {
      console.log(this.participantsWithRatings[1].rating.punctuality);
    }
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRatePunctualityPage');
  }

}
