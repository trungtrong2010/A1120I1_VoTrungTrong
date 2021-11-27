import {Component, OnInit} from '@angular/core';
import {CustomerDao} from "../../../dao/customer/CustomerDao";
import {TypeCustomerDao} from "../../../dao/customer/TypeCustomerDao";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TypeCustomer} from "../../../model/customer/TypeCustomer";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customerForm !: FormGroup;
  isSubmit : boolean = false;
  typeCustomers = TypeCustomerDao;
  constructor() {
  }


  ngOnInit(): void {
    this.customerForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      typeCustomer: new FormControl('', [Validators.required]),
      dayOfBirthday: new FormControl('', [Validators.required]),
      cccd: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required])
    })
  }

  onSubmit() {

    // let idTypeCustomerForm = this.customerForm.value.typeCustomer;
    // let typeCustomerForm = TypeCustomerDao[idTypeCustomerForm-1]
    // this.customerForm.value.typeCustomer = typeCustomerForm;
    // console.log(this.customerForm.value)

    if (!this.customerForm.invalid) {
      CustomerDao.push(this.customerForm.value);
      this.isSubmit = false;
    } else {
      this.isSubmit = true;
    }
  }
}
