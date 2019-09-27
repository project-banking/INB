import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContactusService {

 
  constructor(private https: HttpClient) { }
  private baseUrladminlogin = 'http://localhost:8080/user/contact-us';
  newcontact(contact){
    return  this.https.post<any>(this.baseUrladminlogin,contact);
  }
}
