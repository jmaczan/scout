import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {Team} from "../../models/team";
import {TeamService} from "../../providers/team-service";

/**
 * Generated class for the TeamAddPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-team-add',
  templateUrl: 'team-add.html',
})
export class TeamAddPage {

  team: Team = new Team();
  addTeamInvoked: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private teamService: TeamService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TeamAddPage');

  }

  logEvent(event) {
    this.teamService.addTeam(this.team);
    this.addTeamInvoked = true;
  }

}
