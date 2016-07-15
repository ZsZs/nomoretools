import { provideRouter, RouterConfig } from '@angular/router';
import { HomeComponent } from './home.component';
import { RegisterComponent } from './user/register.component';

export const routes: RouterConfig = [
  { path: '', redirectTo: 'home', terminal: true },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent }
];

export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes)
];
