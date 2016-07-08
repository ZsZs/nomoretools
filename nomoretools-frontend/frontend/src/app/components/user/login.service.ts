import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';

@Injectable()
export class LoginService {
  token: string;

  constructor ( private http: Http ) {}

  sendCredentials( model: any ) {
    let tokenUrl = 'http://localhost:8080/user/login';
    let headers1 = new Headers({'Content-type': 'application/json'});

    return this.http.post( tokenUrl, JSON.stringify( model ), { headers: headers1 });
  }

  sendToken( token: string ) {
    let userUrl = 'http://localhost:8080/rest/user/users';
    let headers2 = new Headers({ 'Authorization': 'Bearer ' + token });

    return this.http.get(userUrl, { headers: headers2 });
  }

  checkLogin() {
    if ( localStorage.getItem( 'currentUserName' ) !== '' && localStorage.getItem( 'token' ) !== '') {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.setItem( 'token', '');
    localStorage.setItem( 'currentUserName', '' );
    alert( 'You just logged out.' );
  }
}
