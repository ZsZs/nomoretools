/**
 * Created by Zsolt on 8/17/2016.
 */

import {
   Component,
   ComponentFactory,
   ComponentMetadata,
   ComponentResolver,
   Directive,
   Input,
   OnChanges,
   ReflectiveInjector,
   ViewContainerRef
} from '@angular/core';

export function createComponentFactory( resolver: ComponentResolver, metadata: ComponentMetadata ): Promise<ComponentFactory<any>> {
   const cmpClass = class DynamicComponent {};
   const decoratedCmp = Component( metadata )( cmpClass );
   return resolver.resolveComponent( decoratedCmp );
}

@Directive( {
   selector: '[nmtDynamicHtmlOutlet]'
})

export class DynamicHtmlOutletDirective implements OnChanges {
   @Input() src: string;

   constructor( private vcRef: ViewContainerRef, private resolver: ComponentResolver ) {
   }

   ngOnChanges() {
      if ( !this.src ) { return; }

      const metadata = new ComponentMetadata( {
         selector: 'dynamic-html',
         template: this.src
      });

      createComponentFactory( this.resolver, metadata )
         .then( factory => {
            const injector = ReflectiveInjector.fromResolvedProviders( [], this.vcRef.parentInjector );
            this.vcRef.createComponent( factory, 0, injector, [] );
         });
   }
}

@Component( {
   selector: 'nmt-smart-document',
   template: `
        <dynamic-html-outlet data-editable data-name="document-content" [innerHTML]="html"></dynamic-html-outlet>
    `,
   directives: [ DynamicHtmlOutletDirective ]
} )

export class DocumentComponent {
   html = '<div><p>Dynamic HTML Fragment</p></div>';
}