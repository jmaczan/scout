import {Component, Input} from '@angular/core';
import {App, IonicPage, NavController, NavParams} from 'ionic-angular';
import {Person} from "../../models/person";
import {PersonDetailsPage} from "../person-details/person-details";

/**
 * Generated class for the PersonPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-person',
  templateUrl: 'person.html',
})
export class PersonPage {

  @Input()
  person: Person;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonPage');
  }

  showPersonDetails(person: Person) {
    this.appCtrl.getRootNav().push(PersonDetailsPage, {
      person: person
    });
  }

}
