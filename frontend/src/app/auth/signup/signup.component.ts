import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/_services/auth.service';
import { Router } from '@angular/router';
import { SignUpRequest } from 'src/app/_dtos/auth/SignUpRequest';
import { ApiResponse } from 'src/app/_dtos/common/ApiResponse';
import { NbDialogService } from '@nebular/theme';
import { DialogSuccessComponent } from 'src/app/shared/dialog/dialog-alert/dialog-success.component';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  loading: Boolean = false
  signUpFrom: FormGroup

  constructor(private _authService: AuthService, private fb: FormBuilder, private router: Router, private dialogService: NbDialogService) {
    this.signUpFrom = this.fb.group({
      email: ["", Validators.compose([Validators.required, Validators.email])],
      password: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
      cpassword: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
      name: ["", [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    }, this.pwdMatchValidator);
  }

  ngOnInit(): void {

  }

  pwdMatchValidator(frm: FormGroup) {
    return frm.get('password').value === frm.get('cpassword').value
       ? null : {'mismatch': true};
  }

  register() {
    if (this.signUpFrom.valid) {
      let data = this.signUpFrom.value
      this.loading = true
      this._authService.register(new SignUpRequest(data['name'], data['email'], data['password'])).subscribe(
        (response: ApiResponse) => {
          this.loading = false
          this.dialogService.open(DialogSuccessComponent, {
            context: { title: "Congratulation", message: response.message }
          })
          this.signUpFrom.reset()
        }, (err: any) => {
          this.loading = false
          console.log(err.error.message)
        }
      )
    }
  }

}
