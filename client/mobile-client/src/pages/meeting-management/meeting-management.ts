import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {MeetingsListPage} from "../meetings-list/meetings-list";
import {MeetingAddTeamsPage} from "../meeting-add-teams/meeting-add-teams";

/**
 * Generated class for the MeetingManagementPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-management',
  templateUrl: 'meeting-management.html',
})
export class MeetingManagementPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingManagementPage');
  }

  openMeetingsList() {
    this.appCtrl.getRootNav().push(MeetingsListPage);
  }

  addMeeting() {
    this.appCtrl.getRootNav().push(MeetingAddTeamsPage);
  }

  removeMeeting() {

  }

}
