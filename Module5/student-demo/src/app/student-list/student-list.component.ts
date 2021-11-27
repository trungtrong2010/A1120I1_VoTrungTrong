import {Component, OnInit} from '@angular/core';
import {StudentDao} from '../dao/StudentDao';
import {IStudent} from '../model/IStudent';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  studens = StudentDao;
  detailStudent: IStudent;

  constructor() {
  }

  ngOnInit(): void {
  }

  getStudent(student: IStudent) {
    this.detailStudent = student;
  }
}
