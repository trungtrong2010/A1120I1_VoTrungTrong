import {Component, Input, OnInit} from '@angular/core';
import {CustomerDao} from '../../../dao/customer/CustomerDao';
import {TypeCustomerDao} from '../../../dao/customer/TypeCustomerDao';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../../model/customer/Customer';
import {element} from 'protractor';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor() {
  }

  @Input() customerEdit: Customer;
  isSubmit = false;
  typeCustomers = TypeCustomerDao;
  customers = CustomerDao;

  customerForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', [Validators.required]),
    typeCustomer: new FormControl('', [Validators.required]),
    dayOfBirthday: new FormControl('', [Validators.required]),
    cccd: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required])
  });
  ngOnInit(): void {}

  onSubmit() {
    if (!this.customerForm.invalid) {
      // console.log(this.customerForm.value.id);
      // console.log(this.customerForm.value);

      if (this.customerForm.value.id === null) {
        do {
          this.customerForm.value.id = Math.floor(Math.random() * 3);
          // console.log(this.customerForm.value.id);
          // console.log(this.customers.every(c => c.id !== this.customerForm.value.id));
        } while (this.customers.some(c => c.id === this.customerForm.value.id));
        this.customers.push(this.customerForm.value);
      }
      // this.customerForm.reset();
      // console.log(this.customers);
      this.isSubmit = false;
    } else {
      this.isSubmit = true;
    }
  }
}
