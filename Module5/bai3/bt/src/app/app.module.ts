import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { PetComponent } from './pet/pet.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { HackernewsComponent } from './hackernews/hackernews.component';
@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    CalculatorComponent,
    PetComponent,
    ColorPickerComponent,
    HackernewsComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
