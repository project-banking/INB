import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginModule } from './login/login.module';
import { UserModule } from './user/user.module';

import { InfoModule } from './info/info.module';
import { HomeModule } from './home/home.module';
import { DashboardModule } from './dashboard/dashboard.module';

import { AdmindashboardModule } from './admindashboard/admindashboard.module';
import { IntercepterService } from './login/intercept.service';
import { DataService } from './login/data.service';
import { FaqInfoComponent } from './faq-info/faq-info.component';
import { AboutusInfoComponent } from './aboutus-info/aboutus-info.component';
import { TeamComponent } from './team/team.component';


@NgModule({
  declarations: [
    AppComponent,
   
    HeaderComponent,
    FooterComponent,
    FaqInfoComponent,
    AboutusInfoComponent,
    TeamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AdmindashboardModule,
    LoginModule,
    UserModule,
    DashboardModule,
    HomeModule,
    InfoModule,
    ReactiveFormsModule,
  
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS,
      useClass:IntercepterService,
      multi: true,},DataService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
