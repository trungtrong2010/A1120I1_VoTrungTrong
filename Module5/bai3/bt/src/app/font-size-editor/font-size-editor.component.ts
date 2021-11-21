import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-size-editor',
  templateUrl: './font-size-editor.component.html',
  styleUrls: ['./font-size-editor.component.css']
})

export class FontSizeEditorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  x = 12;

  setFontSize(event: Event){
    // @ts-ignore
    // console.log(event.target.value),
    this.x = event.target.value
  }

}
