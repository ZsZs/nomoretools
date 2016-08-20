import { Component, Input } from '@angular/core';
import { Discipline } from './discipline';
import { DisciplineRepository } from './discipline.repository';
import { DocumentComponent } from '../document/smart-document';

@Component({
    selector: 'nmt-discipline-details',
    templateUrl: 'app/discipline/discipline-details.component.html',
    directives: [DocumentComponent]
})

export class DisciplineDetailsComponent {
    @Input() discipline: Discipline;

    constructor( private disciplineRepository: DisciplineRepository ) {
    }
}
