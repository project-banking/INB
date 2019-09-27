import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-login-forms',
  templateUrl: './login-forms.component.html',
  styleUrls: ['./login-forms.component.css']
})
export class LoginFormsComponent implements OnInit {
  
  login : FormGroup;
  adminlogin : FormGroup;
  submit: boolean;
  showstatus: string;
  adminstatus: string;
  admin: boolean;
  submitted = false;
  constructor(private loginService: LoginService,private router: Router,private formBuilder: FormBuilder,private dataService : DataService) { }

  ngOnInit() {
    this.login = this.formBuilder.group({
      username: ['', Validators.required,],
      password: ['', Validators.required,],
      admin:false
    })

    this.adminlogin = this.formBuilder.group({
      username:   ['', Validators.required,],
      password:  ['', Validators.required,],
      admin:true
    })
  }
  usernav(){
    console.log(this.login.value)
    this.router.navigate(['dashboard/dashboard'])
  }
  adminnav(){
    console.log(this.adminlogin.value.username)
    if(this.adminlogin.value.username == "admin"  && this.adminlogin.value.password == "password"){
      this.adminlogin.value.admin = true
    }
  
  }
  logged() {
    console.log('user data', this.login.value)
    this.loginService.newLogin(this.login.value).subscribe(
      res=> {
        localStorage.setItem('token',res.token);
 
        console.log(res);
        this.dataService.sendMessage(res);           
        
     
        this.usernav();
      },
      err=> {console.log("error",err.status)
    if(err){
      this.showstatus = "invalid login";
      this.submit = true;
    }
    }
  
    )
  }
  navadmin(){
    this.router.navigate(['admindashboard/admindashboard'])
  }
  get f() { return this.login.controls; }
  get fb() { return this.adminlogin.controls; }
  sendMessage(): void {
    // send message to subscribers via observable subject
    this.dataService.sendMessage('Message from Home Component to App Component!');
}

  clearMessages(): void {
    // clear messages
    this.dataService.clearMessages(); 
  }


  adminloginmsg() {
    console.log('user data', this.adminlogin.value)
    this.loginService.newadminLogin(this.adminlogin.value).subscribe(
      res=> {
        localStorage.setItem('token',res.token); 
             
        this.dataService.sendMessage(res.firstName);
        
     console.log(res)
        this.navadmin();
      },
      err=> {console.log("error",err.status)
    if(err.status == 403){
      this.adminstatus = "invalid login";
      this.submit = true;
    }
    }
  
    )
      
  }
//user login onsubmit
  onSubmit(){
    this.submitted = true;
    console.log(this.login.value)
    if (this.login.invalid) {
      return;
    }
    this.logged()
    
   
  }
//admin login onsubmit
  onSubmitadmin(){
    this.submitted = true;
    console.log(this.adminlogin.value)
    if (this.adminlogin.invalid) {
      return;
    }
    this.adminloginmsg()
    
  }

}
