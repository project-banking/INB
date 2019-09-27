import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardContactusComponent } from './dashboard-contactus/dashboard-contactus.component';
import { MoneyTransferComponent } from './money-transfer/money-transfer.component';
import { AdminGuard } from '../admin.guard';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { ChequedepositComponent } from './chequedeposit/chequedeposit.component';
import { BillpaymentComponent } from './billpayment/billpayment.component';
import { RechargeComponent } from './recharge/recharge.component';
import { AccountdetailsComponent } from './accountdetails/accountdetails.component';
import { AddmoneyComponent } from './addmoney/addmoney.component';
import { BroadbandComponent } from './broadband/broadband.component';
import { AlltransactionComponent } from './alltransaction/alltransaction.component';
import { MinistatementComponent } from './ministatement/ministatement.component';


const routes: Routes = [
 { path: 'dashboard/dashboard', component: DashboardComponent,canActivate: [AdminGuard],
 children: [ { path: 'profile' , component: ProfileComponent, canActivate: [AdminGuard]},
 { path: 'contactus' , component: DashboardContactusComponent,canActivate: [AdminGuard]},
 { path: 'addmoney' , component: AddmoneyComponent,canActivate: [AdminGuard]},
 { path: 'money-transfer' , component: MoneyTransferComponent, canActivate: [AdminGuard]},
 { path: 'broadband' , component: BroadbandComponent, canActivate: [AdminGuard]},
 { path: 'createaccount' , component: CreateaccountComponent, canActivate: [AdminGuard]},
 { path: 'chequedeposit' , component: ChequedepositComponent, canActivate: [AdminGuard]},
 { path: 'billpayment' , component: BillpaymentComponent, canActivate: [AdminGuard]},
 { path: 'recharge' , component: RechargeComponent, canActivate: [AdminGuard]},
 { path: 'accountdetails' , component: AccountdetailsComponent, canActivate: [AdminGuard]},
 { path: 'alltransaction' , component: AlltransactionComponent, canActivate: [AdminGuard]},
 { path: 'ministatement' , component: MinistatementComponent, canActivate: [AdminGuard]}
 ]

},
  





  

];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
