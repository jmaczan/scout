import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Team} from "../../models/team";
import {SplashScreen} from "@ionic-native/splash-screen";
import {TeamService} from "../../providers/team-service";

/**
 * Generated class for the TeamsListPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-teams-list',
  templateUrl: 'teams-list.html',
})
export class TeamsListPage {

  private teams: Team[];
  private justStarted: boolean = true;
  private teamsLoaded: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private teamService: TeamService) {
    console.log('TeamsListPage: constructor invoked');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TeamsListPage');
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

  fetchTeamsAndMembersList() {
    return new Promise((resolve, reject) => {
      this.teamService.getAllTeamsAndMembers().subscribe(
        res => {
          this.teams = res;
          this.teamsLoaded = true;
        }, err => {
          this.teams = [];
          this.teamsLoaded = true;
        }
      );
    })
  }

  fetchTeamsList() {
    return new Promise((resolve, reject) => {
       this.teamService.getAllTeams().subscribe(
        res => {
          this.teams = res;
          this.teamsLoaded = true;
        }, err => {
          this.teams = [];
          this.teamsLoaded = true;
        }
      );
    })
  }

  private doRefresh(refresher) {
    console.log('TeamsListPage: teams list refresh requested', refresher);
    this.fetchTeamsList().then(
      res => {
      console.log("refreshed");
    },
      err => {
      console.log("not refreshed");
      });
  }

  nothing() {

  }

}
