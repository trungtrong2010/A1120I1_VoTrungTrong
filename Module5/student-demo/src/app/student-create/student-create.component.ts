import { Component, OnInit } from '@angular/core';
import {IStudent} from '../model/IStudent';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentDao} from '../dao/StudentDao';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  isSubmit = false;

  studentForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    mark: new FormControl('', Validators.required),
    avatar: new FormControl('')
  });
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.studentForm.invalid) {
      this.studentForm.get('id').reset(StudentDao.length + 1);
      StudentDao.push(this.studentForm.value);
      this.isSubmit = false;
    } else {
      this.isSubmit = true;
    }
  }
}
