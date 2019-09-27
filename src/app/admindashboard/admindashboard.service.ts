import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdmindashboardService {
 
  
  constructor(private http: HttpClient) { }
  urls = "http://localhost:8080/user/fetch?status=pending";
  urlsapproved = "http://localhost:8080/user/fetch?status=approved";
  urlsrejected = "http://localhost:8080/user/fetch?status=rejected";
  transurls = "http://localhost:8080/transaction/fetch/admin?status=pending";
  getcustomer(){
    
 return this.http.get(this.urls);
  }

  getapprovedcustomer(){
    
    return this.http.get(this.urlsapproved);
     }

     getrejectedcustomer(){
    
      return this.http.get(this.urlsrejected);
       }

  approveduser(id : number){
    let body='';
    return this.http.put("http://localhost:8080/user/update/"+`${id}`+"?status=approved",body);
  }

  updateuser(id : number){
    let status='';
    return this.http.put("http://localhost:8080/user/update/"+`${id}`+"?status=rejected",status);
  }

  
  getcustomertransaction(){
    console.log("work2")
    return this.http.get("http://localhost:8080/transaction/fetch/admin?status=pending");
     }
   
     approvedtransaction(id : number){
    let body='';
    return this.http.put("http://localhost:8080/transaction/update/"+`${id}`+"?status=approved",body);
  }

  updateusertransaction(id : number){
    let status='';
    return this.http.put("http://localhost:8080/transaction/update/"+`${id}`+"?status=rejected",status);
  }
  allcustomertransaction(acno:number){
    return this.http.get("http://localhost:8080/transaction/fetch?accountNumber="+`${acno}`+"&miniStatement=true");
    }
  
}

