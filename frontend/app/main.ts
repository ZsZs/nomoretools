// Imports for loading & configuring the in-memory web api
import { Logger } from "angular2-logger/core";
import { XHRBackend } from '@angular/http';
import { InMemoryBackendService, SEED_DATA } from 'angular2-in-memory-web-api';
import { DisciplineData } from './discipline-data';

// The usual bootstrapping imports
import { bootstrap }    from '@angular/platform-browser-dynamic';
import { APP_ROUTER_PROVIDERS } from './app.routes';
import { HTTP_PROVIDERS } from '@angular/http';
import { AppComponent } from './app.component';

bootstrap( AppComponent, [APP_ROUTER_PROVIDERS, HTTP_PROVIDERS, Logger]).catch( err => console.error( err ));
