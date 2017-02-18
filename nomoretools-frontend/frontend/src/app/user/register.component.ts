import {Component} from '@angular/core';
import {User} from './user';
import {RegisterService} from './register.service';

@Component ({
  selector: 'nmt-register',
  templateUrl: './register.component.html'
})

export class RegisterComponent {
  newUser: User = new User();
  registered = false;

  constructor ( private registerService: RegisterService ) {}

  onSubmit() {
    this.registerService.sendUser(this.newUser).subscribe(
      data => {
        this.registered = true;
        this.newUser = new User();
      },
      error => console.log(error)
    );
  }
}
