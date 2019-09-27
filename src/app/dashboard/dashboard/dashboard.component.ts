import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { Router } from '@angular/router';
import { DataService } from 'src/app/login/data.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  firstName;
  messages: any[] = [];
  userdata : any;
  subscription: Subscription;
  constructor(private dataService: DataService, private router: Router) { 
    
    this.subscription = this.dataService.getMessage().subscribe(message => {
      
      if (message) {
      this.messages.push(message);
      console.log(message);
      console.log("Message",message.text);
      console.log("Message",message.text.accountResponseDTO);
      console.log("Message",message.text.accountResponseDTO[0].balance);
      
      this.userdata = message.text.accountResponseDTO
      console.log("Message",this.userdata.balance);
      this.firstName = message.text
      } else {
      // clear messages when empty message received
      this.messages = [];
  }
})
    }

    onClickMe(){
      localStorage.removeItem('token');
    this.router.navigate(['']);
    }
  ngOnInit() {

  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
