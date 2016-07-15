import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {HTTP_PROVIDERS} from '@angular/http';
import {NavBarComponent} from './nav-bar.component';
import {DisciplineRepository} from './discipline/discipline.repository';
import {LoginService} from './user/login.service';
import {RegisterService} from './user/register.service';

@Component({
   selector: 'nmt-app-component',
   directives: [ROUTER_DIRECTIVES, NavBarComponent],
   providers: [HTTP_PROVIDERS, DisciplineRepository, LoginService, RegisterService],
   template: `
    <nmt-nav-bar></nmt-nav-bar>
    <router-outlet></router-outlet>
    `
})

export class AppComponent {}
