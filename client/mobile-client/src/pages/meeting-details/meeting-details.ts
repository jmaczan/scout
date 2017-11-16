import {Component, Input} from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {Meeting} from "../../models/meeting";

/**
 * Generated class for the MeetingDetailsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-details',
  templateUrl: 'meeting-details.html',
})
export class MeetingDetailsPage {

  @Input()
  meeting: Meeting;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.meeting = navParams.get('meeting');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingDetailsPage');
  }

}
