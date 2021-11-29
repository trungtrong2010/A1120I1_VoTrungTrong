import { Component, OnInit } from '@angular/core';
import {CustomerDao} from '../../../dao/customer/CustomerDao';
import {MatDialog} from '@angular/material/dialog';
import {DetailCustomerComponent} from '../detail-customer/detail-customer.component';
import {Customer} from '../../../model/customer/Customer';
import {DeleteCustomerComponent} from '../delete-customer/delete-customer.component';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers = CustomerDao;
  customerEdit: Customer;

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {

  }

  openDialogDetail(customer: Customer) {
    const dialogRef = this.dialog.open(DetailCustomerComponent, {
      width: '400px',
      // height: '700px',
      data: customer
    });
    // dialogRef.afterClosed().
  }

  openDialogDelete(customer: Customer) {
    // console.log(this.customers);
    // this.customers = this.customers.filter(item => item !== customer);
    // console.log(this.customers);
    const dialogRef = this.dialog.open(DeleteCustomerComponent, {
      data: customer
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.customers = this.customers.filter(item => item !== customer);
      }
    });
  }

  editCustomer(customer: Customer) {
    this.customerEdit = customer;
  }
}
