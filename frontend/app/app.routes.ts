import { provideRouter, RouterConfig } from '@angular/router';
import { HomeComponent } from './components/home.component';
import { DisciplineDetailsComponent } from './components/discipline/discipline-details.component';

export const routes: RouterConfig = [
  {path:'', redirectTo: 'home', terminal: true},
  {path:'home', component: HomeComponent}
];

export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes)
];