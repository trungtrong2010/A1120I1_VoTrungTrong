import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormGroup} from '@angular/forms';
import {RapService} from '../service/rap.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ListComponent} from '../list/list.component';
import {IPhim} from '../model/IPhim';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  phims: IPhim[];
  ngayHienTai = new Date();

  compareWith(item1: any, item2: any) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public formGroup: FormGroup,
              private service: RapService,
              private snackbar: MatSnackBar,
              private dialog: MatDialogRef<ListComponent>) { }

  ngOnInit(): void {
    this.service.getAllPhim().subscribe(
      (data) => this.phims = data
    );
  }

}
