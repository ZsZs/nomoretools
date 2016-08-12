import { AfterContentInit, Component, Input } from '@angular/core';
import { ContentEditor } from './editor/content-editor';
import { Discipline } from './discipline/discipline';
import { DisciplineListComponent } from './discipline/discipline-list.component';
import { DisciplineDetailsComponent } from './discipline/discipline-details.component';

@Component({
  selector: 'nmt-home',
  directives: [DisciplineListComponent, DisciplineDetailsComponent],
  providers: [],
  templateUrl: 'app/home.component.html'
})

export class HomeComponent implements AfterContentInit {
   contentEditor: ContentEditor;
    selectedDiscipline: Discipline;
    @Input() disciplines: Discipline[];

   ngAfterContentInit() {
      this.contentEditor = new ContentEditor();
      this.contentEditor.initialize();
   }
}
