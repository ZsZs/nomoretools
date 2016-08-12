/// <reference path="../../typings/index.d.ts" />

// Imports for loading & configuring the in-memory web api

// The usual bootstrapping imports
import { bootstrap }    from '@angular/platform-browser-dynamic';
import { APP_ROUTER_PROVIDERS } from './app.routes';
import { HTTP_PROVIDERS } from '@angular/http';
import { AppComponent } from './app.component';
import { provide } from '@angular/core';

bootstrap( AppComponent, [APP_ROUTER_PROVIDERS, HTTP_PROVIDERS, provide( Window, { useValue: window })]).catch( err => console.error( err ));
