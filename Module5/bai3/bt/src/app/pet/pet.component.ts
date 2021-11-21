import { Component, OnInit } from '@angular/core';
import {Pet} from "../models/test";

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})



export class PetComponent implements OnInit {

  pet : Pet = {
    name : "puppie",
    image: "http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg"
  }

  constructor() { }

  ngOnInit(): void {
  }

  setName($event: Event) {
    // @ts-ignore
    this.pet.name = event.target.value;
  }

  setImage($event: Event) {
// @ts-ignore
    this.pet.image = event.target.value;
  }
}
