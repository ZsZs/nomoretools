import { provideRouter, RouterConfig } from '@angular/router';
import { HomeComponent } from './components/home.component';
import { DisciplineDetailsComponent } from './components/discipline/discipline-details.component';
import { RegisterComponent } from './components/user/register.component';

export const routes: RouterConfig = [
  {path:'', redirectTo: 'home', terminal: true},
  {path:'home', component: HomeComponent},
  {path:'register', component: RegisterComponent}
];

export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes)
];