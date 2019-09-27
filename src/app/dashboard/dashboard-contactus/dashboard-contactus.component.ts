import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ContactusService } from '../contactus.service';

@Component({
  selector: 'app-dashboard-contactus',
  templateUrl: './dashboard-contactus.component.html',
  styleUrls: ['./dashboard-contactus.component.css']
})
export class DashboardContactusComponent implements OnInit {
  contactus: FormGroup;
  constructor(private router: Router, private formBuilder: FormBuilder, private contactusservice : ContactusService) { }

  ngOnInit() {
    this.contactus = this.formBuilder.group({
      firstName: ['', Validators.required,],
      lastName: ['', Validators.required,],
     
      queries: ['', Validators.required,],
      username: ['', Validators.required,],
      
    })
  }

  contact() {
    console.log('user data', this.contactus.value)
    this.contactusservice.newcontact(this.contactus.value).subscribe(
      res=> {
       
        alert("!!!Thank you for contacting us!!!")
        this.router.navigate(['dashboard/dashboard'])
        
      },
 
   
  
    )
      
  }

  onSubmit() {

    console.log(this.contactus.value)
    this.contact()
  }

}
