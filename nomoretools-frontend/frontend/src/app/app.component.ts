import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <nmt-nav-bar></nmt-nav-bar>
    <router-outlet></router-outlet>
`
})
export class AppComponent {
  title = 'app works!';
}
