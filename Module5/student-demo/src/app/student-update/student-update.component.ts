import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../service/student.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {IStudent} from '../model/IStudent';

@Component({
  selector: 'app-student-update',
  templateUrl: './student-update.component.html',
  styleUrls: ['./student-update.component.css']
})
export class StudentUpdateComponent implements OnInit {

  student: IStudent;

  constructor(
    private studentService: StudentService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
  }

  studentForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    mark: new FormControl('', Validators.required),
    avatar: new FormControl('')
  });
  isSubmit = false;

  ngOnInit(): void {
    this.student = this.studentService.getById(this.activatedRoute.snapshot.params['id']);
  }

  onSubmit() {
    if (this.studentForm.valid) {
      this.studentService.addStudent(this.studentForm.value);
      this.router.navigateByUrl('/');
    }
  }
}
