import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})

export class CalculatorComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  x: number | undefined;
  y: number | undefined;
  pt: string | undefined;
  result: number | undefined;

  varibleX($event: Event) {
    // @ts-ignore
    this.x = event.target.value
  }

  varibleY($event: Event) {
    // @ts-ignore
    this.y = event.target.value
  }

  pheptinh($event: Event) {
    // @ts-ignore
    this.pt = event.target.value
  }

  clickSubmit() {
    switch (this.pt) {
      case "+":
        // @ts-ignore
        this.result = +this.x + +this.y;
        break;
      case "-":
        // @ts-ignore
        this.result = this.x - this.y;
        break;
      case "*":
        // @ts-ignore
        this.result = this.x * this.y;
        break;
      case "/":
        // @ts-ignore
        this.result = this.x / this.y;
        break;
    }
  }
}
