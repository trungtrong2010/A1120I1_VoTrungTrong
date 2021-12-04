import {Injectable} from '@angular/core';
import {IStudent} from '../model/IStudent';
import {StudentDao} from '../dao/StudentDao';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class StudentService {

  readonly APT_URL = 'http://localhost:3000/students';

  constructor(private httpClient: HttpClient) {
  }

  getAllStudent(): Observable<IStudent[]> {
    return this.httpClient.get<IStudent[]>(this.APT_URL);
  }

  addStudent(student: IStudent): Observable<IStudent> {
    return this.httpClient.post<IStudent>(this.APT_URL, student);
  }

  updateStudent(student: IStudent): Observable<IStudent> {
    return this.httpClient.put<IStudent>(this.APT_URL + '/' + student.id, student);
  }

  removeStudent(student: IStudent): Observable<IStudent> {
    // remove student in students
    // filter tạo ra mảng mới không có student muốn xóa ==> gán lại cho this.students
    // return this.students = this.students.filter(item => item !== student);
    return this.httpClient.delete<IStudent>(this.APT_URL + '/' + student.id);
  }

  getById(id: any): Observable<IStudent> {
    // for (const student of this.students) {
    //   if (id == student.id) {
    //     return student;
    //   }
    // }
    // return null;
    return this.httpClient.get<IStudent>(this.APT_URL + '/' + id);
  }
}
