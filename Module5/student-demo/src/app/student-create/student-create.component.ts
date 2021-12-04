import {Component, OnInit} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentDao} from '../dao/StudentDao';
import {StudentService} from '../service/student.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  isSubmit = false;

  studentForm = new FormGroup({
    id: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    mark: new FormControl('', Validators.required),
    avatar: new FormControl('')
  });

  constructor(private studentService: StudentService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.studentForm.value);
    if (this.studentForm.valid) {
      this.studentService.addStudent(this.studentForm.value).subscribe();
      this.router.navigateByUrl('/');
    } else {
      this.isSubmit = true;
    }
  }
}
