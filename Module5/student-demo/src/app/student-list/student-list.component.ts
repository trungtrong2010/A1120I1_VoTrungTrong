import {Component, OnInit} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {StudentService} from '../service/student.service';
import {MatDialog} from '@angular/material/dialog';
import {StudentInformationComponent} from '../student-information/student-information.component';
import {StudentDeleteComponent} from '../student-delete/student-delete.component';

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
  openDialogDelete(student: IStudent) {
    const dialog = this.dialog.open(StudentDeleteComponent, {
      width: '20%',
      data: student
    });
    // click button delete ==> check = true
    dialog.afterClosed().subscribe(check => {
      if (check) {
        this.students = this.studentService.removeStudent(student);
      }
    });
  }
}
