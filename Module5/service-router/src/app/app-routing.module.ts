import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimeComponent} from './time/time.component';

const routes: Routes = [
  {
    path: 'time', component: TimeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
