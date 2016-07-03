import {Component} from '@angular/core';
import {LoginService} from './login.service';

@Component({
  selector: 'nmt-login',
  templateUrl: 'app/components/login.component.html'
})

export class LoginComponent {
  private model = {'username': '', 'password': ''};
  private currentUserName: string;

  constructor (private loginService: LoginService) {}

  onSubmit() {
    this.loginService.sendCredentials(this.model).subscribe(
      data => {
        localStorage.setItem( 'token', JSON.parse(JSON.stringify(data))._body );
        this.loginService.sendToken( localStorage.getItem( 'token' )).subscribe(
          loginData => {
            this.currentUserName = this.model.username;
            localStorage.setItem( 'currentUserName', this.model.username );
            this.model.username = '';
            this.model.password = '';
          }
        );
      }
    );
  }
}
