import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Observable";
import {PersonRestService} from "./person-rest-service";
import {Person} from "../models/person";
import {Subscription} from "rxjs/Subscription";

/*
  Generated class for the PersonServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class PersonService {

  persons: Person[] = null;

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

        this.persons = persons;

        return persons;
      },
      error => {
        console.error("Failed to load persons.");
        return [];
      }
    );
  }

  addPerson(person: Person) {
    return this.personRestService.addPerson(person).subscribe();
  }

  removePersonSubscriptionFunctions(person: Person,
                                    onNext: () => void,
                                    onError: () => void) : Subscription {
    return this.personRestService.removePerson(person).subscribe(next => { onNext() }, error => { onError() } );
  }

  removePerson(person: Person) : Subscription {
    return this.personRestService.removePerson(person).subscribe();
  }

}
