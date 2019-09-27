import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InfoRoutingModule } from './info-routing.module';

import { FaqInfoComponent } from './faq-info/faq-info.component';
import { AboutusInfoComponent } from './aboutus-info/aboutus-info.component';


@NgModule({
  declarations: [ FaqInfoComponent, AboutusInfoComponent],
  imports: [
    CommonModule,
    InfoRoutingModule
  ]
})
export class InfoModule { }
