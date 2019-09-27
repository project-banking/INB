import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardNavComponent } from './dashboard-nav/dashboard-nav.component';
import { DashboardSidebarComponent } from './dashboard-sidebar/dashboard-sidebar.component';
import { DashboardContactusComponent } from './dashboard-contactus/dashboard-contactus.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AddmoneyComponent } from './addmoney/addmoney.component';
import { MoneyTransferComponent } from './money-transfer/money-transfer.component';
import { DashboardImgComponent } from './dashboard-img/dashboard-img.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { BillpaymentComponent } from './billpayment/billpayment.component';
import { RechargeComponent } from './recharge/recharge.component';
import { ChequedepositComponent } from './chequedeposit/chequedeposit.component';
import { AccountdetailsComponent } from './accountdetails/accountdetails.component';
import { BroadbandComponent } from './broadband/broadband.component';
import { AlltransactionComponent } from './alltransaction/alltransaction.component';
import { MinistatementComponent } from './ministatement/ministatement.component';
import { DashboardFooterComponent } from './dashboard-footer/dashboard-footer.component';


@NgModule({
  declarations: [DashboardComponent, ProfileComponent, DashboardNavComponent, DashboardSidebarComponent, DashboardContactusComponent, AddmoneyComponent, MoneyTransferComponent, DashboardImgComponent, CreateaccountComponent, BillpaymentComponent, RechargeComponent, ChequedepositComponent, AccountdetailsComponent, BroadbandComponent, AlltransactionComponent, MinistatementComponent, DashboardFooterComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
