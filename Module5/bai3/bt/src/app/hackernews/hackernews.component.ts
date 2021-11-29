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

  // updateArticle() {
  //   console.log("1");
  //   // @ts-ignore
  //   this.article.title = document.getElementById("article-title").value;
  //   console.log(this.article.title);
  //   // @ts-ignore
  //   this.article.url = document.getElementById("article-url").value;
  //   console.log(this.article.url);

  // }
}
