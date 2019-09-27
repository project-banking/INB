import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { Router } from '@angular/router';
import { DataService } from 'src/app/login/data.service';
@Component({
  selector: 'app-accountdetails',
  templateUrl: './accountdetails.component.html',
  styleUrls: ['./accountdetails.component.css']
})
export class AccountdetailsComponent implements OnInit {
  accountNumber: any;
  balance: any;
  accountType: any;
  messages: any[] = [];
  userdata : any;
  num : []
  subscription: Subscription;
  constructor(private dataService: DataService, private router: Router) {

    this.subscription = this.dataService.getMessage().subscribe(message => {
      
      if (message) {
      this.messages.push(message);
      console.log(message);
      console.log("Message",message.text);
      console.log("Message",message.text.accountResponseDTO);
      console.log("Message",message.text.accountResponseDTO[0].balance);
      this.num = message.text.accountResponseDTO
      this.userdata = message.text.accountResponseDTO[0]
     this.accountNumber = this.userdata.accountNumber
     this.balance = this.userdata.balance
     this.accountType = this.userdata.accountType
      
      } else {
      // clear messages when empty message received
      this.messages = [];
  }
})
   }

  ngOnInit() {
  }

}
