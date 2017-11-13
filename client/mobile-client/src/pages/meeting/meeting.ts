import {Component, Input} from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {Meeting} from "../../models/meeting";

/**
 * Generated class for the MeetingPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting',
  templateUrl: 'meeting.html',
})
export class MeetingPage {

  @Input()
  meeting: Meeting;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingPage');
  }

}
