import { Component, OnInit } from '@angular/core';
import {Article} from "../models/article";

@Component({
  selector: 'app-hackernews',
  templateUrl: './hackernews.component.html',
  styleUrls: ['./hackernews.component.css']
})
export class HackernewsComponent implements OnInit {

  article : Article = {
    title : "Facebook",
    url : "https://facebook.com"
  }

  constructor() { }

  ngOnInit(): void {
  }

}
