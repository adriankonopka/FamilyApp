import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-read-family',
  templateUrl: './read-family.component.html',
  styleUrls: ['./read-family.component.css']
})
export class ReadFamilyComponent implements OnInit {

  familys$: Object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getFamily().subscribe(
      data => this.familys$ = data
    );
  }

}
