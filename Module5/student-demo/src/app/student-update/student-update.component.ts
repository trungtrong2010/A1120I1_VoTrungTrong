import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../service/student.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {IStudent} from '../model/IStudent';
import {error} from 'protractor';

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

  // studentForm: FormGroup;
  isSubmit = false;
  studentForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    mark: new FormControl('', Validators.required),
    avatar: new FormControl('')
  });

  ngOnInit(): void {
    let id;
    this.activatedRoute.paramMap.subscribe(
      (paramMap: ParamMap) => {
        id = paramMap.get('id');
      }
    );
    console.log(id);
    this.studentService.getById(id).subscribe(
      (data) => this.student = data,
      () => {},
      () => {
        this.studentForm.setValue({
          id: this.student.id,
          name: this.student.name,
          age: this.student.age,
          mark: this.student.mark,
          avatar: this.student.avatar
        });
        console.log(this.studentForm.value);
        console.log('a');
      }
    );
  }

  onSubmit() {
    if (this.studentForm.valid) {
      this.studentService.updateStudent(this.studentForm.value).subscribe();
      console.log(this.studentForm.value);
      this.router.navigateByUrl('/');
    }
  }
}
