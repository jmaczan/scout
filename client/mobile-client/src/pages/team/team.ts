import {Component, Input} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Team} from "../../models/team";
import {TeamMemberDetails} from "../../models/team-member-details";
import {TeamMemberWithFunction} from "../../models/team-member-function";

/**
 * Generated class for the TeamPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-team',
  templateUrl: 'team.html',
})
export class TeamPage {

  @Input()
  team: Team;
  members: TeamMemberWithFunction[];
  teamMemberDetailsLoaded = false;
  isMembersListToggled = false;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TeamPage');
  }

  toggleMembers() {
    this.isMembersListToggled = !this.isMembersListToggled;
  }

  teamMemberDetailsLoad() {

  }

  showMembersInTheTeam() {

  }

}
