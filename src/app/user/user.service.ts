import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8080/user/registration';
  newRegistration(users1:object):Observable<object>{
    return this.http.post(this.baseUrl,users1);
  }
}
@Injectable({
  providedIn: 'root'
})
export class Users{
  constructor(private https: HttpClient) { }
  private baseUrllogin = 'http://localhost:8080/user/login';
  newLogin(users2:object):Observable<object>{
    return this.https.post(this.baseUrllogin,users2);
  }
}
