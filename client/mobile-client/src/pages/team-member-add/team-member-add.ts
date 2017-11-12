import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {TeamService} from "../../providers/team-service";
import {PersonService} from "../../providers/person-service";
import {Member} from "../../models/member";

/**
 * Generated class for the TeamMemberAddPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-team-member-add',
  templateUrl: 'team-member-add.html',
})
export class TeamMemberAddPage {

  private teamId: number;
  private personId: number;
  private addTeamMemberInvoked: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, public teamService: TeamService, public personService: PersonService) {
  }

  ionViewWillEnter() {
    this.personService.getAllPersons().subscribe();
    console.log('ionViewDidLoad TeamMemberAddPage');
  }

  addTeamMember() {
    let memberToAdd: Member = new Member();
    memberToAdd.teamId = this.teamId;
    memberToAdd.personId = this.personId;
    this.teamService.addTeamMember(memberToAdd);
    this.addTeamMemberInvoked = true;
  }

}
