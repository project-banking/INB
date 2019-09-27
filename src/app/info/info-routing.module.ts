import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FaqInfoComponent } from './faq-info/faq-info.component';
import { AboutusInfoComponent } from './aboutus-info/aboutus-info.component';
import { AdminGuard } from '../admin.guard';



const routes: Routes = [
  { path : 'faq-info', component: FaqInfoComponent},
  { path : 'aboutus-info', component: AboutusInfoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InfoRoutingModule { }
