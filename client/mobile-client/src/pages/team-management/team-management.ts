import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {TeamsListPage} from "../teams-list/teams-list";

/**
 * Generated class for the TeamManagementPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-team-management',
  templateUrl: 'team-management.html',
})
export class TeamManagementPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TeamManagementPage');
  }

  openTeamMembers() {
    this.appCtrl.getRootNav().push(TeamsListPage);
  }

  addTeam() {

  }

  modifyTeam() {

  }

  removeTeam() {

  }

}
