import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from "../model/IStudent";

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.css']
})
export class StudentInformationComponent implements OnInit {

  @Input() studentDetail !: IStudent;

  constructor() {

  }

  ngOnInit(): void {
  }

}
