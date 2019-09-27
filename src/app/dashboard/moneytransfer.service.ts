import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MoneytransferService {

  constructor(private https: HttpClient) { }

  private baseUrladminlogin = 'http://localhost:8080/transaction/add';
  addmoney(admoney) {
    return this.https.post<any>(this.baseUrladminlogin, admoney);
  }
  private baseUrl = 'http://localhost:8080/transaction/add';
  transfermoney(transfermoney) {
    return this.https.post<any>(this.baseUrl, transfermoney);
  }

  private baseUrlbillpayment = 'http://localhost:8080/transaction/pay/utility';
  billpayment(billpayment) {
    return this.https.post<any>(this.baseUrlbillpayment, billpayment);
  }

  private baseUrlrecharge = 'http://localhost:8080/transaction/pay/utility';
  recharg(recharge) {
    return this.https.post<any>(this.baseUrlrecharge, recharge);
  }

  private baseUrlbroadband = 'http://localhost:8080/transaction/pay/utility';
  broadband(broadband) {
    return this.https.post<any>(this.baseUrlrecharge, broadband);
  }
  private baseUrlcheque = 'http://localhost:8080/transaction/add';
  cheque(cheque) {
    return this.https.post<any>(this.baseUrlcheque, cheque);
  }

  private baseUrls = 'http://localhost:8080/account/add';
  creteaccount(addaccount) {
    return this.https.post<any>(this.baseUrls, addaccount);
  }
  customertransaction(acno:number){
    return this.https.get("http://localhost:8080/transaction/fetch?accountNumber="+`${acno}`+"&miniStatement=true");
    }
    allcustomertransaction(acno:number){
    return this.https.get("http://localhost:8080/transaction/fetch?accountNumber="+`${acno}`+"&miniStatement=true");
    }

}
