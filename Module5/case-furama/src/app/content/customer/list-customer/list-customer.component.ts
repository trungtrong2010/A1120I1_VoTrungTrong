import { Component, OnInit } from '@angular/core';
import {CustomerDao} from "../../../dao/customer/CustomerDao";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers = CustomerDao;

  constructor() {
  }

  ngOnInit(): void {

  }

}
