import { Injectable } from '@angular/core';
import { DISCIPLINES } from './mock.disciplines';

@Injectable()
export class DisciplineRepository {
    getDiscipline(id: number) {
        return this.getDisciplines().then(disciplines => disciplines.filter(discipline => discipline.id === id)[0]);
    }

    getDisciplines(){
        return Promise.resolve( DISCIPLINES );
    }
}