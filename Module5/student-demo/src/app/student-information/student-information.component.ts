import {Component, Inject, Input, OnInit} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.css']
})
export class StudentInformationComponent implements OnInit {

  @Input() studentDetail: IStudent;

  constructor(
    @Inject(MAT_DIALOG_DATA) public student: IStudent) {

  }

  ngOnInit(): void {
  }

  setMark($event: any) {
    this.studentDetail.mark = $event.target.value;
  }
}
