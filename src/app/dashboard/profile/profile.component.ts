import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { Router } from '@angular/router';
import { DataService } from 'src/app/login/data.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  firstName: any;
  lastName: any;
  customerId: any;
  username:any;
  email:any;
  addressLine1:any;
  addressLine2:any;
  addressLine3:any;
  city:any;
  state:any;
  zip:any;
  mobile:any;
  userdata : any;
  messages: any[] = [];
  subscription: Subscription;
  constructor(private dataService: DataService, private router: Router) { 
    this.subscription = this.dataService.getMessage().subscribe(message => {
      if (message) {
      this.messages.push(message);
     console.log(message);
      this.userdata = message.text;
      console.log("Message",message.text);

      this.lastName = this.userdata.lastName;
      this.firstName = this.userdata.firstName;
      this.customerId = this.userdata.customerId;
      this.username = this.userdata.username;
      this.email = this.userdata.email;
      this.addressLine1 = this.userdata.addressLine1;
      this.addressLine2 = this.userdata.addressLine2;
      this.addressLine3 = this.userdata.addressLine3;
      this.city = this.userdata.city;
      this.state = this.userdata.state;
      this.zip = this.userdata.zip;
      this.mobile = this.userdata.phone;
      console.log(this.lastName);
      console.log(this.firstName);
      console.log(this.mobile);
      console.log(this.zip);
      } else {
      // clear messages when empty message receive
     this.messages = [];
  }
})
    }

    ngOnDestroy(){
      this.subscription.unsubscribe();
    }

  ngOnInit() {
  }

}
