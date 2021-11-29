import {Component, OnInit} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {StudentService} from '../service/student.service';
import {MatDialog} from '@angular/material/dialog';
import {StudentInformationComponent} from '../student-information/student-information.component';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: IStudent[];

  constructor(public dialog: MatDialog, private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.students = this.studentService.getAllStudent();
  }

 openDialogDetail(student: IStudent) {
    const dialog = this.dialog.open(StudentInformationComponent, {
      width: '500px',
      data: student
    });
  }
}
