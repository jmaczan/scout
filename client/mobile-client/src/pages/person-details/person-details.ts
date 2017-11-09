import {Component, Input} from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Person} from "../../models/person";

/**
 * Generated class for the PersonDetailsPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-person-details',
  templateUrl: 'person-details.html',
})
export class PersonDetailsPage {

  @Input()
  person: Person;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
    this.person = navParams.get('person');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonDetailsPage');
  }

}
