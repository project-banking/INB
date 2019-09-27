import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmindashboardRoutingModule } from './admindashboard-routing.module';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdmindashboardNavComponent } from './admindashboard-nav/admindashboard-nav.component';
import { PendingrequestComponent } from './pendingrequest/pendingrequest.component';
import { ApprovedrequestComponent } from './approvedrequest/approvedrequest.component';
import { RejectedrequestComponent } from './rejectedrequest/rejectedrequest.component';
import { ApprovmoneyComponent } from './approvmoney/approvmoney.component';
import { HomeimgComponent } from './homeimg/homeimg.component';
import { DetailstatementComponent } from './detailstatement/detailstatement.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [AdmindashboardComponent, AdmindashboardNavComponent, PendingrequestComponent, ApprovedrequestComponent, RejectedrequestComponent, ApprovmoneyComponent, HomeimgComponent, DetailstatementComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    AdmindashboardRoutingModule
  ]
})
export class AdmindashboardModule { }
