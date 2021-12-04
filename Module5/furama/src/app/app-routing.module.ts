import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './content/customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './content/customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './content/customer/edit-customer/edit-customer.component';


const routes: Routes = [
  {path: '', component: ListCustomerComponent},
  {path: 'create', component: CreateCustomerComponent},
  {path: 'edit/:id', component: EditCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
