import {Component, Input} from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Team} from "../../models/team";
import {Member} from "../../models/member";
import {MemberDetailsPage} from "../member-details/member-details";

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
  teamMemberDetailsLoaded = false;
  isMembersListToggled = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TeamPage');
  }

  toggleMembers() {
    this.isMembersListToggled = !this.isMembersListToggled;
  }

  showMemberDetails(member: Member) {
    this.appCtrl.getRootNav().push(MemberDetailsPage, {
      member: member
    });

  }

  loadTeamMemberDetailsIfNotLoaded() {

  }


  showMembersInTheTeam() {

  }

}
