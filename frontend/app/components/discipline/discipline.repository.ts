import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Discipline } from './discipline';

@Injectable()
export class DisciplineRepository {
    private disciplineUrl = 'app/disciplines';  // URL to web api

    constructor( private http: Http ) { }
    
    find( id: number ) {
        return this.findAll().then( disciplines => disciplines.filter( discipline => discipline.id === id)[0] );
    }

    findAll(): Promise<Discipline[]> {
        return this.http.get( this.disciplineUrl ).toPromise().then( response => response.json().data ).catch( this.handleError );
    }
    
    private add( discipline: Discipline ): Promise<Discipline> {
        let headers = new Headers({ 'Content-Type': 'application/json' });

        return this.http.post( this.disciplineUrl, JSON.stringify( discipline ), { headers: headers }).toPromise().then(res => res.json().data).catch(this.handleError);
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

        return this.http.put( url, JSON.stringify( discipline ), { headers: headers }).toPromise().then(() => discipline ).catch(this.handleError);
    }


    private handleError( error: any ) {
        console.error( 'An error occurred', error );
        return Promise.reject( error.message || error );
    }
}