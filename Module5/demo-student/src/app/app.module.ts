import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentInformationComponent } from './student-information/student-information.component';
import { StudentCreateComponent } from './student-create/student-create.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentInformationComponent,
    StudentCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
