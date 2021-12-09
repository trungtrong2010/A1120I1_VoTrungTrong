import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ISoTietKiem} from '../model/ISoTietKiem';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: ISoTietKiem) {}

  ngOnInit(): void {
  }

}
