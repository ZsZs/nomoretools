import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Discipline } from './discipline';
import { DisciplineDetailsComponent } from './discipline-details.component';
import { DisciplineRepository } from './discipline.repository';

@Component({
    selector: 'nmt-discipline-list',
    directives: [DisciplineDetailsComponent],
    providers: [],
    styles: ['.selected {background-color: #CFD8DC !important; color: white;}'],
    templateUrl: 'app/discipline/discipline-list.component.html'
})

export class DisciplineListComponent implements OnInit {
    @Input() disciplines: Discipline[];
    @Input() selectedDiscipline: Discipline;
    @Output() selectedChange: EventEmitter<Discipline> = new EventEmitter<Discipline>();
    errorMessage: any;

    constructor( private disciplineRepository: DisciplineRepository ) {
    }

    ngOnInit() {
        this.disciplineRepository.findAll().then( disciplines => this.disciplines = disciplines, error =>  this.errorMessage = <any>error );
    }

    onSelect( discipline: Discipline ) {
        this.selectedDiscipline = discipline;
    }
}
