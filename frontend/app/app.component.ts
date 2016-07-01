import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {HTTP_PROVIDERS} from '@angular/http';
import {Logger} from "angular2-logger/core";
import {NavBar} from './components/nav-bar.component';
import {Discipline} from './components/discipline/discipline';
import {DisciplineRepository} from './components/discipline/discipline.repository';
import {RegisterService} from './components/user/register.service';

@Component({
   selector: 'app',
   directives: [ROUTER_DIRECTIVES, NavBar],
   providers: [HTTP_PROVIDERS, DisciplineRepository, RegisterService, Logger],
   template: `
    <nav-bar></nav-bar>
    <router-outlet></router-outlet>
    `
})

export class AppComponent { 
}
