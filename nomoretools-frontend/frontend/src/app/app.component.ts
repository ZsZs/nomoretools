import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {HTTP_PROVIDERS} from '@angular/http';
import {NavBarComponent} from './components/nav-bar.component';
import {DisciplineRepository} from './components/discipline/discipline.repository';
import {RegisterService} from './components/user/register.service';

@Component({
   selector: 'nmt-app-component',
   directives: [ROUTER_DIRECTIVES, NavBarComponent],
   providers: [HTTP_PROVIDERS, DisciplineRepository, RegisterService],
   template: `
    <nmt-nav-bar></nmt-nav-bar>
    <router-outlet></router-outlet>
    `
})

export class AppComponent {}
