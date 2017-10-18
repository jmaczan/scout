import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {Member} from "../../models/member";

/**
 * Generated class for the ModifyMemberDetailsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-modify-member-details',
  templateUrl: 'modify-member-details.html',
})
export class ModifyMemberDetailsPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ModifyMemberDetailsPage');
  }

}
