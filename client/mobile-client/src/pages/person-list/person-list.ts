import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Person} from "../../models/person";
import {PersonService} from "../../providers/person-service";

/**
 * Generated class for the PersonListPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-person-list',
  templateUrl: 'person-list.html',
})
export class PersonListPage {

  private persons: Person[];
  private justStarted: boolean = true;
  private personsLoaded: boolean = false;


  constructor(public navCtrl: NavController, public navParams: NavParams, private personService: PersonService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PersonListPage');
    this.fetchPersons();
  }

  ionViewDidEnter() {
    if (this.justStarted) {
      this.justStarted = false;
      this.fetchPersons().then(
        res => {
        },
        err => {
          console.log("Failed to fetch persons.");
        }
      );
    }
  }

  fetchPersons() {
    return new Promise((resolve, reject) => {
      this.personService.getAllPersons().subscribe(
        res => {
          this.persons = res;
          this.personsLoaded = true;
        }, err => {
          this.persons = [];
          this.personsLoaded = true;
        }
      );
    })
  }

  doRefresh(refresher) {
    console.log('TeamsListPage: teams list refresh requested', refresher);
    this.fetchPersons().then(
      refresher.complete());
  }


  nothing() {

  }
}
