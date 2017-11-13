import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {Meeting} from "../../models/meeting";

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

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingsListPage');
  }

}
