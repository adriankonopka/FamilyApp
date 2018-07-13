import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Father} from './add-father/Father';
import {Observable} from 'rxjs';
import { catchError } from 'rxjs/operators';
import {ContentType} from '@angular/http/src/enums';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/x-www-form-urlencoded'
  })
};

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getFamily() {
    return this.http.get('http://192.168.1.2:8080/all');
  }

  addFather(){
    return this.http.get('192.168.1.2:8080/AddFatherToFamily', httpOptions);
  }
}
