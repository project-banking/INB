import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { MoneytransferService } from '../moneytransfer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {
createaccount : FormGroup
submitted = false
  constructor(private formBuilder: FormBuilder,private moneytransferService: MoneytransferService,private router : Router) { }

  ngOnInit()  {
    this.createaccount = this.formBuilder.group({
      customerId: ['', Validators.required,],
      accountType: ['', Validators.required,]
    })
  }
  get f() { return this.createaccount.controls; }
  onSubmitaddmoney(){
    this.submitted = true;
      console.log(this.createaccount.value)
      if (this.createaccount.invalid) {
        return;
      }
    this.moneytransferService.creteaccount(this.createaccount.value).subscribe(
      res=> {
        alert("Your account is"+res.status)
        this.router.navigate(['dashboard/dashboard'])
         },
 
   
  
    )
  }


}
