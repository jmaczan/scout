import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Member} from "../../models/member";
import {Team} from "../../models/team";
import {MeetingRatePunctualityPage} from "../meeting-rate-punctuality/meeting-rate-punctuality";

/**
 * Generated class for the MeetingAddParticipantsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-add-participants',
  templateUrl: 'meeting-add-participants.html',
})
export class MeetingAddParticipantsPage {

  chosenTeams: any[] = [];
  chosenMembers: any[] = [];
  membersLoaded: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.chosenTeams = navParams.get("chosenTeams");
    this.chosenTeams.forEach(team => {
      team.team.members.forEach(member => {
        this.chosenMembers.push({member: member, checked: false});
      });
    });
    this.membersLoaded = true;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingAddParticipantsPage');
  }

  logEvent(event) {
    this.ratePunctuality();
  }

  ratePunctuality() {
    this.appCtrl.getRootNav().push(MeetingRatePunctualityPage, {chosenMembers: this.chosenMembersFiltered(), chosenTeams: this.chosenTeamsFiltered() });
  }

  chosenMembersFiltered() : any[] {
    return this.chosenMembers.filter(value => value.checked);
  }

  chosenTeamsFiltered() : number[] {
    let teamsInvolved: number[] = [];
    this.chosenTeams.forEach(chosenTeam => {
      if(!(teamsInvolved.includes(chosenTeam.team.id))) {
        teamsInvolved.push(chosenTeam.team.id);
      }
    });

    return teamsInvolved;
  }

  ionViewDidEnter() {

  }

}
