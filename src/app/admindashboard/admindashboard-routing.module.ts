import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { PendingrequestComponent } from './pendingrequest/pendingrequest.component';
import { ApprovedrequestComponent } from './approvedrequest/approvedrequest.component';
import { RejectedrequestComponent } from './rejectedrequest/rejectedrequest.component';
import { AdminGuard } from '../admin.guard';
import { AddmoneyComponent } from '../dashboard/addmoney/addmoney.component';
import { ApprovmoneyComponent } from './approvmoney/approvmoney.component';
import { HomeimgComponent } from './homeimg/homeimg.component';
import { DetailstatementComponent } from './detailstatement/detailstatement.component';


const routes: Routes = [
  { path : 'admindashboard/admindashboard', component: AdmindashboardComponent, canActivate: [AdminGuard],
    children:[
      { path : '', redirectTo:'homeimg',pathMatch:'full'},
      { path : 'homeimg', component: HomeimgComponent, canActivate: [AdminGuard]},
      { path : 'pendingrequest', component: PendingrequestComponent, canActivate: [AdminGuard]},
  { path : 'approvedrequest', component: ApprovedrequestComponent, canActivate: [AdminGuard]},
  { path : 'rejectedrequest', component: RejectedrequestComponent, canActivate: [AdminGuard]},
  { path : 'approvedMoney', component: ApprovmoneyComponent, canActivate: [AdminGuard]},
  { path : 'detailstatemnet', component: DetailstatementComponent, canActivate: [AdminGuard]},
    ]
},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmindashboardRoutingModule { }
