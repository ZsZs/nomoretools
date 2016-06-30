import {Component, Input} from '@angular/core';
import {Discipline} from './discipline';
import {DisciplineRepository} from './discipline.repository';

@Component({
    selector: 'discipline-details',
    templateUrl: 'app/components/discipline/discipline-details.component.html'
})

export class DisciplineDetailsComponent implements OnInit, OnDestroy {
    @Input() discipline: Discipline;
    
    constructor(private disciplineRepository: DisciplineRepository ) {
    }
}
