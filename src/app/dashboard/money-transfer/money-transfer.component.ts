import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-money-transfer',
  templateUrl: './money-transfer.component.html',
  styleUrls: ['./money-transfer.component.css']
})
export class MoneyTransferComponent implements OnInit {
  moneytransfer : FormGroup
  submitted = false
  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router: Router) { }

  ngOnInit() {
    this.moneytransfer = this.formBuilder.group({
      sourceAccountNo: ['', Validators.required,],
      targetAccountNo: ['', Validators.required,],
      amount: ['', Validators.required,]
    })
  }
  get f() { return this.moneytransfer.controls; }
  onSubmitmoneytransfer(){
   this.submitted = true;
      console.log(this.moneytransfer.value)
      if (this.moneytransfer.invalid) {
        return;
      }
    this.moneytransferService.transfermoney(this.moneytransfer.value).subscribe(
      res=> {
        alert("Payment "+res.status)
        this.router.navigate(['dashboard/dashboard'])
         },
  )
  }

}
