import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Father} from './Father';
import {DataService} from '../data.service';
import {FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-add-father',
  templateUrl: './add-father.component.html',
  styleUrls: ['./add-father.component.css']
})
export class AddFatherComponent implements OnInit {

  father: Father;

  registerForm: FormGroup;
  submitted = false;

  constructor(private data: DataService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    // this.allertt.visibility = true;
    document.getElementById('allert').style.visibility = 'hidden';
    this.registerForm = this.formBuilder.group(
      {firstName: ['', Validators.required],
        secondName: ['', Validators.required],
        pesel: ['', Validators.required],
        birthDate: ['', Validators.required]
      });
  }
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.addFather(this.f.firstName.valueOf().toString(),this.f.secondName.valueOf().toString(),this.f.pesel.valueOf().toString(),this.f.birthDate);
    alert('SUCCESS!! :-)');
  }

  addFather(firstName: string, secondName: string, pesel: string, birthDate: Date) {
    this.father = {familyId: null, firstName: firstName, secondName: secondName, pesel: pesel, birthDate: birthDate} as Father;
    this.data.addFather(this.father).subscribe();
  }
}
