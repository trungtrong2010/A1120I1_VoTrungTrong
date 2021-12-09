import {Component, OnInit} from '@angular/core';
import {IEmploye} from '../../../model/employee/IEmploye';
import {EmployeeService} from '../../../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: IEmploye[];

  constructor(private service: EmployeeService) {

  }

  ngOnInit(): void {
    this.service.getAllEmployee().subscribe(
      (data) => {
        this.employees = data;
      },
      () => {},
      () => {
        console.log(this.employees);
      }
    )
    ;
  }

}

