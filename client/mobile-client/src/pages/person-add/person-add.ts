import {Component, Input} from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {Person} from "../../models/person";
import {PersonService} from "../../providers/person-service";

/**
 * Generated class for the PersonAddPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-person-add',
  templateUrl: 'person-add.html',
})
export class PersonAddPage {

  person: Person = new Person();
  addPersonInvoked: boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App, private personService: PersonService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonAddPage');
  }

  logEvent(event) {
    this.personService.addPerson(this.person);
    this.addPersonInvoked = true;
  }

}
