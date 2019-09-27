import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-broadband',
  templateUrl: './broadband.component.html',
  styleUrls: ['./broadband.component.css']
})
export class BroadbandComponent implements OnInit {
  serviceProvider: String;
  telephoneNumber: number;
  broadband : FormGroup;
  plans: number;
submitted = false
  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router:Router) { }

  

  ngOnInit() {
    this.broadband = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      amount: ['', Validators.required,],
      utilityType: "internet"
    })
  }
  getServiceProviders($event){
    this.serviceProvider=$event.target.value
    console.log(this.serviceProvider)
  }
  getTelephoneNumber($event){
    this.telephoneNumber=$event.target.value
    console.log(this.telephoneNumber)
  }
  getPlans($event){
    this.plans=$event.target.value
    console.log(this.plans)
  }
  get f() { return this.broadband.controls; }
  submit(){
    this.submitted = true;
    console.log(this.broadband.value)
    if (this.broadband.invalid) {
      return;
    }
    console.log(this.broadband.value)
    this.moneytransferService.billpayment(this.broadband.value).subscribe(
      res=> {
        alert("payment "+res.status)
        this.router.navigate(['dashboard/dashboard'])
         },
    )
  }

  
  


}
