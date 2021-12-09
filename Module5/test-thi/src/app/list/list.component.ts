import {Component, OnInit} from '@angular/core';
import {SotietkiemService} from '../service/sotietkiem.service';
import {ISoTietKiem} from '../model/ISoTietKiem';
import {MatDialog} from '@angular/material/dialog';
import {DetailComponent} from '../detail/detail.component';
import {CreateComponent} from '../create/create.component';
import {DeleteComponent} from '../delete/delete.component';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EditComponent} from '../edit/edit.component';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {min} from 'rxjs/operators';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  soTietKiems: ISoTietKiem[];

  formTietKiem = new FormGroup({
      id: new FormControl(),
      khachHang: new FormControl('', Validators.required),
      ngayMoSo: new FormControl('', [Validators.required]),
      thoigianBatdauGui: new FormControl('', Validators.required),
      kyHan: new FormControl('', Validators.required),
      soTienGui: new FormControl('', [Validators.required, Validators.min(1000000)]),
      laiSuat: new FormControl('', Validators.required),
      uuDai: new FormControl('')
    }
  );
  p: string | number;

  constructor(private sotietkiemService: SotietkiemService,
              public dialog: MatDialog,
              private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.sotietkiemService.getAllSoTietKiem().subscribe(
      (data) => this.soTietKiems = data
    );
  }

  openDialogDetail(soTietKiem: ISoTietKiem) {
    const diaLog = this.dialog.open(DetailComponent, {
      width: '400px',
      data: soTietKiem
    });
  }

  openDialogCreate() {
    const dialog = this.dialog.open(CreateComponent, {
      width: '800px',
      data: this.formTietKiem,
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

  openDialogDelete(soTietKiem: ISoTietKiem) {
    const dialog = this.dialog.open(DeleteComponent, {
      data: soTietKiem
    });
    dialog.afterClosed().subscribe(
      (check) => {
        if (check) {
          this.sotietkiemService.deleteSoTietKiem(soTietKiem.id).subscribe(
            () => {
            },
            () => {
            },
            () => {
              this.snackbar.open('Đã xóa mã số sổ: MSS-' + soTietKiem.id, 'Ok', {
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

  openDialogEdit(soTietKiem: ISoTietKiem) {
    this.formTietKiem.setValue(soTietKiem);
    const dialog = this.dialog.open(EditComponent, {
      width: '800px',
      data: this.formTietKiem
    });
    dialog.afterClosed().subscribe(
      () => {
        this.formTietKiem.reset();
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }


  searchId(element) {
    this.sotietkiemService.searchIdSoTietKiem(element).subscribe(
      (data) => {
        this.soTietKiems = data;
        this.p = 1;
      }
    );
  }
}
