import { Component, OnInit } from '@angular/core';
import { MoneytransferService } from '../moneytransfer.service';
import { Subscription } from 'rxjs';
import { DataService } from 'src/app/login/data.service';
@Component({
selector: 'app-alltransaction',
templateUrl: './alltransaction.component.html',
styleUrls: ['./alltransaction.component.css']
})
export class AlltransactionComponent implements OnInit {
accountno: any;
transaction : {}
messages: any[] = [];
userdata : any;
subscription: Subscription;
constructor(private moneytransferService : MoneytransferService,private dataService: DataService ){

this.subscription = this.dataService.getMessage().subscribe(message => {

if (message) {
this.messages.push(message);
console.log(message);
console.log("Message",message.text);
console.log("Message",message.text.accountResponseDTO);
console.log("Message",message.text.accountResponseDTO[0].balance);

this.userdata = message.text.accountResponseDTO[0]
this.accountno = this.userdata.accountNumber


} else {
// clear messages when empty message received
this.messages = [];
}
})
}
getalltransaction(acno : number){
console.log("work")

this.moneytransferService.allcustomertransaction(acno).subscribe( res => {
this.transaction = res;
console.log(this.transaction);
}, 
error =>{console.log(error);
} 
);
// this.activeRouter.params.subscribe(data =>{
// debugger

// });

}

ngOnInit() {
}

}