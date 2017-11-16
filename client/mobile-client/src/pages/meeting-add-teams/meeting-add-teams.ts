import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Team} from "../../models/team";
import {TeamService} from "../../providers/team-service";
import {MeetingAddParticipantsPage} from "../meeting-add-participants/meeting-add-participants";

/**
 * Generated class for the MeetingAddTeamsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-add-teams',
  templateUrl: 'meeting-add-teams.html',
})
export class MeetingAddTeamsPage {

  teams: Team[];
  teamsWithChoiceDecision: any[] = [];
  private justStarted: boolean = true;
  private teamsLoaded: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App, private teamService: TeamService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingAddTeamsPage');
  }

  ionViewDidEnter() {
    if (this.justStarted) {
      this.justStarted = false;
      this.fetchTeamsAndMembersList().then(
        res => {

        },
        err => {
          console.log("Failed to fetch teams.");
        }
      ).then(
        res => {

        }, err => {
        }
      );
    }
  }

  logEvent(event) {
    this.addParticipants();
  }

  addParticipants() {
    this.appCtrl.getRootNav().push(MeetingAddParticipantsPage, {chosenTeams: this.chosenTeamsFiltered() });
  }

  chosenTeamsFiltered() {
    return this.teamsWithChoiceDecision.filter(value => value.checked);
  }

  fetchTeamsAndMembersList() {
    return new Promise((resolve, reject) => {
      this.teamService.getAllTeamsAndMembers().subscribe(
        res => {
          this.teams = res;
          this.teams.forEach(team => {
            this.teamsWithChoiceDecision.push({team: team, checked: false});
          });
          this.teamsLoaded = true;
        }, err => {
          this.teams = [];
          this.teamsLoaded = true;
        }
      );
    })
  }

  doRefresh(refresher) {
    console.log('TeamsListPage: teams list refresh requested', refresher);
    this.fetchTeamsAndMembersList().then(refresher.complete());
  }


}
