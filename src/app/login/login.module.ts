import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginFormsComponent } from './login-forms/login-forms.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
  




@NgModule({
  declarations: [LoginFormsComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    LoginRoutingModule
  ]
})
export class LoginModule { }
