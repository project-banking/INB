import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-billpayment',
  templateUrl: './billpayment.component.html',
  styleUrls: ['./billpayment.component.css']
})
export class BillpaymentComponent implements OnInit {

  billpayment : FormGroup
  num: number;
  utilityType: String;
state: String;
selectBiller: String;
ivrs: String;
submitted = false

  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router:Router) { }

  ngOnInit() {
    this.billpayment = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      amount: 300,
      utilityType: "electricity"
    })
  }
  onClickMe(){
    this.num = 300
    }
    getState($event){
      this.state=$event.target.value
      console.log(this.state)
    }
    getSelectBiller($event){
      this.selectBiller=$event.target.value
      console.log(this.selectBiller)
    }
    getIVRS($event){
      this.ivrs=$event.target.value;
    }
    
    get f() { return this.billpayment.controls; }
    submit(){
      this.submitted = true;
      console.log(this.billpayment.value)
      if (this.billpayment.invalid) {
        return;
      }
    console.log(this.billpayment.value)
    this.moneytransferService.billpayment(this.billpayment.value).subscribe(
      res=> {
        alert("payment "+res.status)
        this.router.navigate(['dashboard/dashboard'])
         },
 
   
  
    )
  }

}
