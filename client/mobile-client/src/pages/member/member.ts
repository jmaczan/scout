import {Component, Input} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {TeamMemberWithFunction} from "../../models/team-member-function";

/**
 * Generated class for the MemberPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-member',
  templateUrl: 'member.html',
})
export class MemberPage {

  @Input()
  member: TeamMemberWithFunction;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MemberPage');
  }

}
