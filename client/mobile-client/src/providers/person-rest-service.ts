import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the PersonRestServiceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class PersonRestService {

  private personServerURL: string  = "http://localhost:8080/person";
  private getAllPersonsSuffix:  string = "/query";

  constructor(public http: Http) {
    console.log('Hello TeamRestService Provider');
  }

  getAllPersons() {
    const url = this.personServerURL + this.getAllPersonsSuffix;
    return this.http.get(url);
  }



}
