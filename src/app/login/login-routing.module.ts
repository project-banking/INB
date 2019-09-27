import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormsComponent } from './login-forms/login-forms.component';
import { UserRegistrationComponent } from '../user/user-registration/user-registration.component';

const routes: Routes = [
  { path : 'login', component: LoginFormsComponent},
  { path : 'login/user-registration', component: UserRegistrationComponent},
 
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
