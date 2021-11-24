import { Component, OnInit } from '@angular/core';
import {articleDao} from "../dao/articleDao";
import {IArticle} from "../models/article";

@Component({
  selector: 'app-hackernews',
  templateUrl: './hackernews.component.html',
  styleUrls: ['./hackernews.component.css']
})

export class HackernewsComponent implements OnInit {

  articles = articleDao;
  stt : number | undefined;
  title : string | undefined;
  url : string | undefined;
  article = {};

  constructor() { }

  ngOnInit(): void {
  }

  varibleTitle($event: Event) {
    // @ts-ignore
    this.title = event.target.value;
  }

  varibleUrl($event: Event) {
// @ts-ignore
    this.url = event.target.value;
  }

  addArticle() {
    this.articles.push(
      <IArticle>{
        stt: this.articles.length + 1,
        title: this.title,
        url: this.url
      }
    )
  }

  getArticle(article: IArticle) {
    this.article = article;
  }
}
