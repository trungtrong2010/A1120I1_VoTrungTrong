import {Injectable} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {StudentDao} from '../dao/StudentDao';

@Injectable()
export class StudentService {
  students: IStudent[] = StudentDao;

  constructor() {
  }

  getAllStudent() {
    return this.students;
  }

  addStudent(student: IStudent) {
    this.students.push(student);
  }

  getById(id: number) {
    for (const student of this.students) {
      if (id == student.id) {
        return student;
      }
    }
    return null;
  }
}
