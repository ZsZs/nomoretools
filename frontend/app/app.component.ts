import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {NavBar} from './components/nav-bar.component';
import {Discipline} from './components/discipline/discipline';
import {DisciplineRepository} from './components/discipline/discipline.repository';

@Component({
   selector: 'app',
   directives: [NavBar, ROUTER_DIRECTIVES],
    providers: [DisciplineRepository],
    template: `
    <nav-bar></nav-bar>
    <router-outlet></router-outlet>
    `
})

export class AppComponent { 
}
