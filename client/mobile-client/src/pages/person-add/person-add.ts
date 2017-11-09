import {Component, Input} from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {Person} from "../../models/person";

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

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App) {
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonAddPage');
  }

}
