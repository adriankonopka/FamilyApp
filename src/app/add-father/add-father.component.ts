import { Component, OnInit } from '@angular/core';
import {Father} from './Father';
import {DataService} from '../data.service';

@Component({
  selector: 'app-add-father',
  templateUrl: './add-father.component.html',
  styleUrls: ['./add-father.component.css']
})
export class AddFatherComponent implements OnInit {

  father: Father;

  constructor(private data: DataService) { }

  ngOnInit() {
  }

  addFather(firstName: string, secondName: string, pesel: string, birthDate: Date) {
    this.father = {familyId: null, firstName: firstName, secondName: secondName, pesel: pesel, birthDate: birthDate} as Father;
    this.data.addFather(this.father).subscribe();
  }
}
