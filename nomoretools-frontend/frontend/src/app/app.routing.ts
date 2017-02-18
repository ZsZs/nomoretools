import { Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { LoginComponent } from './user/login.component';
import { RegisterComponent } from './user/register.component';

export const APP_ROUTES: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }
];
