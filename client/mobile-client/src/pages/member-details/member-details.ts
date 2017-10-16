import {Component, Input} from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {Member} from "../../models/member";

/**
 * Generated class for the MemberDetailsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-member-details',
  templateUrl: 'member-details.html',
})
export class MemberDetailsPage {

  @Input()
  member: Member;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.member = navParams.get('member');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MemberDetailsPage');
  }

}
