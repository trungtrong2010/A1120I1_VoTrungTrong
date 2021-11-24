import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-detail-hackernews',
  templateUrl: './detail-hackernews.component.html',
  styleUrls: ['./detail-hackernews.component.css']
})
export class DetailHackernewsComponent implements OnInit {

  constructor() { }

  @Input() detailHackernew : any;
  @Input() like: number | undefined;

  ngOnInit(): void {
  }

  setUrl($event: Event) {
    // @ts-ignore
    this.detailHackernew.url.emit($event.target.value)
    console.log(this.detailHackernew.url)
  }
}
