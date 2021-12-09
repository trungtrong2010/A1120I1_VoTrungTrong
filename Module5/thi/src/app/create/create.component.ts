import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {IRap} from '../model/IRap';
import {FormGroup} from '@angular/forms';
import {RapService} from '../service/rap.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {IPhim} from '../model/IPhim';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  phims: IPhim[];

  constructor(@Inject(MAT_DIALOG_DATA) public formGroup: FormGroup,
              private service: RapService,
              private snackbar: MatSnackBar,
              private dialog: MatDialogRef<CreateComponent>) {
  }

  ngayHienTai = new Date();

  ngOnInit(): void {
    this.service.getAllPhim().subscribe(
      (data) => this.phims = data,
      () => {
      },
      () => {
        console.log(this.phims);
      }
    );
  }


  onSubmit() {

    if (this.formGroup.valid) {
      this.service.createRap(this.formGroup.value).subscribe(
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
