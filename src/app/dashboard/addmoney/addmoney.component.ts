import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addmoney',
  templateUrl: './addmoney.component.html',
  styleUrls: ['./addmoney.component.css']
})
export class AddmoneyComponent implements OnInit {
 addmoney : FormGroup
submitted = false
  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router:Router) { }

  ngOnInit() {
    this.addmoney = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      amount: ['', Validators.required,],
      targetAccountNo: 3
    })
  }
  get f() { return this.addmoney.controls; }
  
    
  onSubmitaddmoney(){
    this.submitted = true;
    console.log(this.addmoney.value)
    if (this.addmoney.invalid) {
      return;
    }
    this.addmoney.value.targetAccountNo  = this.addmoney.value.sourceAccountNo
    console.log(this.addmoney.value)
    this.moneytransferService.addmoney(this.addmoney.value).subscribe(
      res=> {
       alert("request for adding money has been successfully submitted")
       this.router.navigate(['dashboard/dashboard'])
         },
 
   
  
    )
  }

}
