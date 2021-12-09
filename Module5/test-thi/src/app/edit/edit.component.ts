import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ISoTietKiem} from '../model/ISoTietKiem';
import {FormGroup} from '@angular/forms';
import {IKhachHang} from '../model/IKhachHang';
import {SotietkiemService} from '../service/sotietkiem.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ListComponent} from '../list/list.component';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {


  kyHans = ['3 tháng', '6 tháng', '9 tháng', '12 tháng'];
  khachHangs: IKhachHang[];
  ngayHienTai = new Date();

  compareWith(item1: any, item2: any) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public formTietKiem: FormGroup,
              private service: SotietkiemService,
              private snackbar: MatSnackBar,
              private dialog: MatDialogRef<ListComponent>) {
  }

  ngOnInit(): void {
    this.service.getAllKhachHang().subscribe(
      (data) => this.khachHangs = data
    );
  }

  onSubmit() {
    if (this.formTietKiem.valid) {
      this.service.updateSoTietKiem(this.formTietKiem.value).subscribe(
        () => {},
        () => {},
        () => {
          this.snackbar.open('Cập nhập Mã số sổ MSS-' + this.formTietKiem.value.id + ' thành công <3 ', 'Ok', {
            duration: 3000
          });
          this.dialog.close();
        },
      );
    }
  }
}
