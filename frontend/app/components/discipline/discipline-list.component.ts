import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Router} from '@angular/router';
import {Discipline} from './discipline';
import {DisciplineDetailsComponent} from './discipline-details.component';
import {DisciplineRepository} from './discipline.repository';

@Component({
    selector: 'discipline-list',
    directives: [DisciplineDetailsComponent],
    providers: [DisciplineRepository],
    styles: ['.selected {background-color: #CFD8DC !important; color: white;}'],
    templateUrl: 'app/components/discipline/discipline-list.component.html'
})

export class DisciplineListComponent implements OnInit {
    @Input() disciplines: Discipline[];
    @Input() selectedDiscipline: Discipline;
    @Output() selectedChange: EventEmitter<Discipline> = new EventEmitter();
    
    constructor(private disciplineRepository: DisciplineRepository) { 
    }
    
    ngOnInit() {
        this.disciplineRepository.getDisciplines().then( disciplines => this.disciplines = disciplines);
    }

    onSelect(discipline: Discipline) { 
        this.selectedDiscipline = discipline;
    }
}
