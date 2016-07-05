import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { Discipline } from './discipline';

@Injectable()
export class DisciplineRepository {
    private port = '8081';
    private disciplineUrl: string;

    constructor( private http: Http ) {
        this.disciplineUrl = 'http://' + window.location.hostname + ':' + this.port + '/disciplines';
    }

    // Public accessors and mutators
    find( id: number ) {
        return this.findAll().then( disciplines => disciplines.filter( discipline => discipline.id === id)[0] );
    }

    findAll(): Promise<Discipline[]> {
        return this.http.get( this.disciplineUrl )
                        .toPromise()
                        .then( this.extractData )
                        .catch( this.handleError );
    }

    add( discipline: Discipline ): Promise<Discipline> {
        let headers = new Headers({ 'Content-Type': 'application/json' });

        return this.http.post( this.disciplineUrl, JSON.stringify( discipline ), { headers: headers })
                        .toPromise()
                        .then( this.extractData )
                        .catch(this.handleError);
    }

    delete( discipline: Discipline ) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        let url = `${this.disciplineUrl}/${ discipline.id }`;

        return this.http.delete( url, headers ).toPromise().catch(this.handleError);
    }

    update( discipline: Discipline ) {
        let headers = new Headers();
        headers.append( 'Content-Type', 'application/json' );
        let url = `${ this.disciplineUrl }/${ discipline.id }`;

        return this.http.put( url, JSON.stringify( discipline ), { headers: headers })
                        .toPromise()
                        .then( () => discipline )
                        .catch( this.handleError );
    }

    // Protected, private helper methods
    private extractData( response: Response ) {
        let body = response.json();
        return body._embedded.data || { };
    }

    private handleError( error: any ) {
        console.error( 'An error occurred', error );
        return Promise.reject( error.message || error );
    }
}
