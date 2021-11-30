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
    student.id = this.students.length + 1;
    this.students.push(student);
  }

  removeStudent(student: IStudent) {
    // remove student in students
    // filter tạo ra mảng mới không có student muốn xóa ==> gán lại cho this.students
  return this.students = this.students.filter(item => item !== student);
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
