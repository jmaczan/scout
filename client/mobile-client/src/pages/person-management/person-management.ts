import { Component } from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {PersonListPage} from "../person-list/person-list";
import {PersonAddPage} from "../person-add/person-add";

/**
 * Generated class for the PersonManagementPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-person-management',
  templateUrl: 'person-management.html',
})
export class PersonManagementPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonManagementPage');
  }

  openAllPersons() {
    this.appCtrl.getRootNav().push(PersonListPage);
  }

  addPerson() {
    this.appCtrl.getRootNav().push(PersonAddPage);
  }

  modifyPerson() {

  }

  removePerson() {

  }

}
