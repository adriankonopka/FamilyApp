import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Father} from './add-father/Father';
import {Observable, throwError} from 'rxjs';
import {Child} from './add-child/Child';
import {catchError} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
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

  addFather(father: Father): Observable<Father> {
    return this.http.post<Father>('http://192.168.1.2:8080/aftf', father, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  addChild(familyId: number, child: Child): Observable<Child>{
    return this.http.put<Child>('http://192.168.1.2:8080/aftf/family/' + familyId, child, httpOptions);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {  /*client side */
      console.error('An error occurred:', error.error.message);
    } else {
    //  server side
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError('try again later');
  }

}
