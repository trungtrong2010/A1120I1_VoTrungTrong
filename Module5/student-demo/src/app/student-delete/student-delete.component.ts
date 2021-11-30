import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {IStudent} from '../model/IStudent';

@Component({
  selector: 'app-student-delete',
  templateUrl: './student-delete.component.html',
  styleUrls: ['./student-delete.component.css']
})
export class StudentDeleteComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public student: IStudent
  ) {
  }

  ngOnInit(): void {
  }
}
