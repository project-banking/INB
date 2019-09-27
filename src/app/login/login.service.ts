import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private https: HttpClient) { }
  private baseUrllogin = 'http://localhost:8080/user/login';
  newLogin(users2){
    return this.https.post<any>(this.baseUrllogin,users2);
  }

  private baseUrladminlogin = 'http://localhost:8080/user/login';
  newadminLogin(admin){
    return  this.https.post<any>(this.baseUrladminlogin,admin);
  }

  getToken(){
    console.log("Print Get Token "+localStorage.getItem('token'));
    return localStorage.getItem('token');
  }
}
