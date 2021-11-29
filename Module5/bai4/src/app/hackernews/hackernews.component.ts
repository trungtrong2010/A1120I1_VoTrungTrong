import {Component, OnInit} from '@angular/core';
import {articleDao} from "../dao/articleDao";

@Component({
  selector: 'app-hackernews',
  templateUrl: './hackernews.component.html',
  styleUrls: ['./hackernews.component.css']
})
export class HackernewsComponent implements OnInit {

  articles = articleDao;

  constructor() {
  }

  ngOnInit(): void {

  }

}
