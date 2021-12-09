import {Component, OnInit} from '@angular/core';
import {RapService} from '../service/rap.service';
import {IRap} from '../model/IRap';
import {MatDialog} from '@angular/material/dialog';
import {CreateComponent} from '../create/create.component';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DeleteComponent} from '../delete/delete.component';
import {MatSnackBar} from '@angular/material/snack-bar';
import {DetailComponent} from '../detail/detail.component';
import {EditComponent} from '../edit/edit.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  raps: IRap[];

  formGroup = new FormGroup({
      id: new FormControl(),
      phim: new FormControl('', Validators.required),
      date: new FormControl('', Validators.required),
      soLuongVe: new FormControl('', Validators.required)
    }
  );

  constructor(private service: RapService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.service.getAllRap().subscribe(
      (data) => this.raps = data
    );
  }

  openDialogDetail(rap: IRap) {
    const diaLog = this.dialog.open(DetailComponent, {
      width: '350px',
      data: rap
    });

  }

  openDialogEdit(rap: IRap) {

    this.formGroup.setValue(rap);
    const dialog = this.dialog.open(EditComponent, {
      width: '800px',
      data: this.formGroup
    });
    dialog.afterClosed().subscribe(
      () => {
        this.formGroup.reset();
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );

  }

  openDialogDelete(rap: IRap) {
    const dialog = this.dialog.open(DeleteComponent, {
      data: rap
    });
    dialog.afterClosed().subscribe(
      (check) => {
        if (check) {
          this.service.deleteRap(rap).subscribe(
            () => {
            },
            () => {
            },
            () => {
              this.snackbar.open('Đã xóa mã suất chiếu: CI-' + rap.id, 'Ok', {
                panelClass: ['mat-toolbar', 'mat-warn'],
                duration: 3000
              });
            }
          );
        }
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }

  openDialogCreate() {
    const dialog = this.dialog.open(CreateComponent, {
      width: '350px',
      data: this.formGroup
    });
    dialog.afterClosed().subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }
}
