import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {APP_ROUTES} from './app.routing';
import {RouterModule} from '@angular/router';
import {HomeComponent} from "./home.component";
import {NavBarComponent} from "./nav-bar.component";
import {LoginComponent} from "./user/login.component";
import {RegisterComponent} from "./user/register.component";
import {DisciplineDetailsComponent} from "./discipline/discipline-details.component";
import {DisciplineListComponent} from "./discipline/discipline-list.component";
import {DisciplineRepository} from "./discipline/discipline.repository";
import {ContentEditor} from "./document-editor/content-editor";

@NgModule({
  declarations: [
    AppComponent,
    DisciplineDetailsComponent,
    DisciplineListComponent,
//    DocumentComponent,
    HomeComponent,
    LoginComponent,
    NavBarComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot( APP_ROUTES )
  ],
  providers: [ContentEditor, DisciplineRepository],
  bootstrap: [AppComponent]
})
export class AppModule {
}
