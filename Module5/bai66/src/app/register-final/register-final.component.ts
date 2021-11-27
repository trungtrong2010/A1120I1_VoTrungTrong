import {Component, OnInit} from '@angular/core';
import {AccountsDao} from "../dao/accountsDao";
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-register-final',
  templateUrl: './register-final.component.html',
  styleUrls: ['./register-final.component.css']
})
export class RegisterFinalComponent implements OnInit {

  accountsDaos = new Array<AccountsDao>()

  constructor() {

  }
  account = new FormGroup({
    email: new FormControl('', [Validators.required,Validators.email]),
    checkPassword : new FormGroup({
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('')
    }, this.comparePassword),
    // password: new FormControl('', Validators.required),
    country: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required),
    phone: new FormControl('+84', Validators.required)
  })

  ngOnInit(): void {

  }

  onSubmit() {
    // this.accountsDaos.push(this.account.value)
  }
  comparePassword(c: AbstractControl){
    console.log("12121")
    const v = c.value;
    return (v.password === v.confirmPassword) ?
      null : {
        passwordnotmatch: true // name error
      }
  }
}


// function ConfirmedValidator(arg0: string, arg1: string): any {
//     return (formGroup: FormGroup) => {
//       const control = formGroup.controls[arg0];
//       const control1 = formGroup.controls[arg1];
//       if (control1.errors && !control1.errors.confirmedValidator) return;
//       if (control.value !== control1.value) {
//         control1.setErrors({confirmedValidator: true})
//       }else control1.setErrors(null);
//     }
// }

