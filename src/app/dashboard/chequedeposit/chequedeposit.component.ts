import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-chequedeposit',
  templateUrl: './chequedeposit.component.html',
  styleUrls: ['./chequedeposit.component.css']
})
export class ChequedepositComponent implements OnInit {

  chequedeposit : FormGroup
  submitted = false
  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService, private router: Router) { }

  ngOnInit() {
    this.chequedeposit = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      amount: ['', Validators.required,],
      targetAccountNo: ['', Validators.required,]
    })
  }
  status(clear){
if(clear == "approved"){
  alert("Cheque:Cleared")
  this.router.navigate(['dashboard/dashboard'])
}else{
  alert("Cheque:Bounced")
  this.router.navigate(['dashboard/dashboard'])
}
  }
  get f() { return this.chequedeposit.controls; }
  submit(){
    this.submitted = true;
    console.log(this.chequedeposit.value)
    if (this.chequedeposit.invalid) {
      return;
    }
    console.log(this.chequedeposit.value)
    this.moneytransferService.cheque(this.chequedeposit.value).subscribe(
      res=> {
       console.log(res)
       this.status(res.status)
         },
 
   
  
    )
  }
}
