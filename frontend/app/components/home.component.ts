import {Component, Input} from '@angular/core';
import {Discipline} from './discipline/discipline';
import {DisciplineListComponent} from './discipline/discipline-list.component';
import {DisciplineDetailsComponent} from './discipline/discipline-details.component';

@Component({
  selector: 'home',
  directives: [DisciplineListComponent, DisciplineDetailsComponent],
  templateUrl: 'app/components/home.component.html'
})

export class HomeComponent {
    selectedDiscipline: Discipline;
    @Input() disciplines: Discipline[];
}
