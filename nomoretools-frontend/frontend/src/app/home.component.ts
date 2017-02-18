import {AfterContentInit, Component, Input} from '@angular/core';
import {ContentEditor} from './document-editor/content-editor';
import {Discipline} from './discipline/discipline';
import {DisciplineRepository} from './discipline/discipline.repository';

@Component({
   selector: 'nmt-home',
   templateUrl: './home.component.html'
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
