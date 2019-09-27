import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.css']
})
export class RechargeComponent implements OnInit {
  recharge : FormGroup
  operators: String;
plans: number;
submitted = false

  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router:Router) { }

  ngOnInit() {
    this.recharge = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      amount: ['', Validators.required,],
      utilityType: "mobile"
    })
  }

  getOperators($event){
    this.operators=$event.target.value
    console.log(this.operators)
  }
  getPlans($event){
    this.plans=$event.target.value
    console.log(this.plans)
  }
  get f() { return this.recharge.controls; }
 
  submit(){
    
      this.submitted = true;
      console.log(this.recharge.value)
      if (this.recharge.invalid) {
        return;
      }
    this.moneytransferService.recharg(this.recharge.value).subscribe(
      res=> {
        alert("Payment "+ res.status + "Thankyou")
        this.router.navigate(['dashboard/dashboard'])
         },
 
   
  
    )
  }

}
