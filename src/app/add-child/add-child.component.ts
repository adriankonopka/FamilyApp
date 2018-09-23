import { Component, OnInit } from '@angular/core';
import {Child} from './Child';
import {Father} from '../add-father/Father';
import {DataService} from '../data.service';

@Component({
  selector: 'app-add-child',
  templateUrl: './add-child.component.html',
  styleUrls: ['./add-child.component.css']
})
export class AddChildComponent implements OnInit {

  child: Child;

  constructor(private data: DataService) { }

  ngOnInit() {
  }

  addChild(familyId: number, firstName: string, secondName: string, pesel: string, sex: string) {
    this.child = {familyId: null, firstName: firstName, secondName: secondName, pesel: pesel, sex: sex} as Child;
    this.data.addChild(familyId, this.child).subscribe();
  }
}
