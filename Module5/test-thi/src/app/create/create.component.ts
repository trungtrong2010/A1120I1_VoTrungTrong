import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ISoTietKiem} from '../model/ISoTietKiem';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ListComponent} from '../list/list.component';
import {IKhachHang} from '../model/IKhachHang';
import {SotietkiemService} from '../service/sotietkiem.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})

export class CreateComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public formTietKiem: FormGroup,
              private service: SotietkiemService,
              private dialog: MatDialogRef<CreateComponent>,
              private snackbar: MatSnackBar) {
  }


  kyHans = ['3 tháng', '6 tháng', '9 tháng', '12 tháng'];
  khachHangs: IKhachHang[];
  ngayHienTai = new Date();


  ngOnInit(): void {
    this.service.getAllKhachHang().subscribe(
      (data) => this.khachHangs = data
    );
  }

  onSubmit() {

    if (this.formTietKiem.valid) {
      this.service.saveSoTietKiem(this.formTietKiem.value).subscribe(
        () => {},
        () => {},
        () => {
          this.snackbar.open('Thêm mới thành công <3 ', 'Ok', {
            duration: 3000
          });
          this.dialog.close();
        }
      );
    }
  }
}
