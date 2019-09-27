import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { UserService } from '../user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';



@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  registration: FormGroup;
  accounttypepattern = "[0-1]{1}$";
  emailpattern = "^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$";

  submitted = false;
  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registration = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', Validators.required],
      username: ['', Validators.required],
      addressLine1: ['', Validators.required],
      addressLine2: [''],
      addressLine3: [''],
      city: ['', Validators.required],
      state:['', Validators.required],
      zip: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.pattern(this.emailpattern)]],
      accounttype: ['', [Validators.required,Validators.pattern(this.accounttypepattern)]]

     
    })
    
  }
 


 
  get f() { return this.registration.controls; }
  
  save() {
    console.log('user data', this.registration.value)
    this.userService.newRegistration(this.registration.value).subscribe(data => console.log(data),
      error => console.log(error));
alert("you have successfully registered")
this.router.navigate(['login'])
  }
  onSubmit() {
    this.submitted = true;
    console.log(this.registration.value)
    if (this.registration.invalid) {
      return;
  }

  this.save();
}
 }
  
