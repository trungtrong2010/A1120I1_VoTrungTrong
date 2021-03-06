import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HackernewsComponent } from './hackernews/hackernews.component';
import { LikesComponent } from './likes/likes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { DetailHackernewsComponent } from './detail-hackernews/detail-hackernews.component';

@NgModule({
  declarations: [
    AppComponent,
    HackernewsComponent,
    LikesComponent,
    NavbarComponent,
    FooterComponent,
    DetailHackernewsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
