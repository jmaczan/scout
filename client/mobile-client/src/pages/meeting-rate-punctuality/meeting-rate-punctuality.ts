import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Member} from "../../models/member";
import {ParticipationRating} from "../../models/participation-rating";

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

  participants: Member[] = [];
  participationRatings: ParticipationRating[] = [];

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    let chosenMembers = navParams.get("chosenMembers");
    chosenMembers.forEach(member => {
      this.participants.push(member.member);
    });
    console.log(this.participants.length);
    console.log(this.participants[0].forename);

    //todo: upchac partycypantow do participationratings
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingRatePunctualityPage');
  }

}
