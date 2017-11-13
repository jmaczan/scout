import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {TeamManagementPage} from "../team-management/team-management";
import {PersonManagementPage} from "../person-management/person-management";
import {SplashScreen} from "@ionic-native/splash-screen";
import {MeetingManagementPage} from "../meeting-management/meeting-management";

/**
 * Generated class for the MainMenuPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-main-menu',
  templateUrl: 'main-menu.html',
})
export class MainMenuPage {

  private justStarted: boolean = true;
  private splashScreen: SplashScreen;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.splashScreen = navParams.get("splashScreen");
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MainMenuPage');
  }

  ionViewDidEnter() {
    if (this.justStarted) {
      this.justStarted = false;
      this.splashScreen.hide();
    }
  }

  openTeamManagement() {
    this.appCtrl.getRootNav().push(TeamManagementPage);
  }

  openPersonManagement() {
    this.appCtrl.getRootNav().push(PersonManagementPage);
  }

  openMeeting() {
    this.appCtrl.getRootNav().push(MeetingManagementPage);
  }
}
