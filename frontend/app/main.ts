// Imports for loading & configuring the in-memory web api
import { XHRBackend } from '@angular/http';
import { InMemoryBackendService, SEED_DATA } from 'angular2-in-memory-web-api';
import { DisciplineData } from './discipline-data';

// The usual bootstrapping imports
import { bootstrap }    from '@angular/platform-browser-dynamic';
import { APP_ROUTER_PROVIDERS } from './app.routes';
import { HTTP_PROVIDERS } from '@angular/http';
import { AppComponent } from './app.component';

bootstrap( AppComponent, [
        APP_ROUTER_PROVIDERS, 
        HTTP_PROVIDERS,
        { provide: XHRBackend, useClass: InMemoryBackendService }, // in-mem server
        { provide: SEED_DATA, useClass: DisciplineData }      // in-mem server data
    ]).catch( err => console.error( err ));
