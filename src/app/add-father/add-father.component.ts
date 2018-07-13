import { Component, OnInit } from '@angular/core';
import {Father} from './Father';
import {DataService} from '../data.service';

@Component({
  selector: 'app-add-father',
  templateUrl: './add-father.component.html',
  styleUrls: ['./add-father.component.css']
})
export class AddFatherComponent implements OnInit {

  father$: Object;

  constructor(private data: DataService) { }

  ngOnInit() {
  }

  addFather(firstName: string, secondName: string, pesel: string, birthDate: Date) {
    this.father$ = { familyId: 1, firstName: firstName, secondName: secondName, pesel: pesel, birthDate: birthDate } as Father;
    this.data.addFather().subscribe(data => this.father$ = data);//console.log('cośwysw:', this.father.firstName, ' date', this.father.birthDate);
  }

}
