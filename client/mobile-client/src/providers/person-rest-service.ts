import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Person} from "../models/person";

/*
  Generated class for the PersonRestServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class PersonRestService {

  private personServerURL: string  = "http://localhost:8080/person";
  private getAllPersonsSuffix:  string = "/query";
  private addPersonSuffix: string = "/command/add";
  private removePersonSuffix: string = "/command/remove"

  constructor(public http: Http) {
    console.log('Hello TeamRestService Provider');
  }

  getAllPersons() {
    const url = this.personServerURL + this.getAllPersonsSuffix;
    return this.http.get(url);
  }

  addPerson(person: Person) {
    const url = this.personServerURL + this.addPersonSuffix;
    return this.http.post(url, person);
  }

  removePerson(person: Person) {
    const url = this.personServerURL + this.removePersonSuffix;
    return this.http.post(url, person);
  }

}
