import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Observable";
import {PersonRestService} from "./person-rest-service";
import {Person} from "../models/person";

/*
  Generated class for the PersonServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class PersonService {

  constructor(public http: Http, private personRestService: PersonRestService) {
    console.log('Hello PersonServiceProvider Provider');
  }

  getAllPersons() : Observable<Person[]> {
    return this.personRestService.getAllPersons().map(
      response => {
        let responseObjects: Object[] = <Object[]> response.json();
        let persons: Person[] = [];

        responseObjects.forEach(object => {
          persons.push(Object.assign(new Person(), object));
        });

        return persons;
      },
      error => {
        console.error("Failed to load persons.");
        return [];
      }
    );
  }

}