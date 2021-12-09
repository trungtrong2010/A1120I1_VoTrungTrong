import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {ListCustomerComponent} from './content/customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './content/customer/create-customer/create-customer.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {DetailCustomerComponent} from './content/customer/detail-customer/detail-customer.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {DeleteCustomerComponent} from './content/customer/delete-customer/delete-customer.component';
import { EditCustomerComponent } from './content/customer/edit-customer/edit-customer.component';
import {HttpClientModule} from '@angular/common/http';
import { EmployeeCreateComponent } from './content/employee/employee-create/employee-create.component';
import { EmployeeDeleteComponent } from './content/employee/employee-delete/employee-delete.component';
import { EmployeeDetailComponent } from './content/employee/employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './content/employee/employee-edit/employee-edit.component';
import { EmployeeListComponent } from './content/employee/employee-list/employee-list.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {NgxPaginationModule} from 'ngx-pagination';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ListCustomerComponent,
    CreateCustomerComponent,
    DetailCustomerComponent,
    DeleteCustomerComponent,
    EditCustomerComponent,
    EmployeeCreateComponent,
    EmployeeDeleteComponent,
    EmployeeDetailComponent,
    EmployeeEditComponent,
    EmployeeListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatDialogModule,
    MatButtonModule,
    HttpClientModule,
    MatSnackBarModule,
    NgxPaginationModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
