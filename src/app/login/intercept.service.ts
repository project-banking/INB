import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpHeaders, HttpEvent, HttpRequest, HttpHandler, HttpResponse } from '@angular/common/http';

import { LoginService } from './login.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IntercepterService implements HttpInterceptor{
 

  constructor(private injector : Injector) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
    let loginService = this.injector.get(LoginService);
    req = req.clone({
      headers: new HttpHeaders ({
        
        'Content-Type': 'application/json',
        Authorization: `Bearer ${loginService.getToken()}`
      })
    });
//     const header =  new HttpHeaders({
//       'Authorization': `Bearer ${loginService.getToken()}`,
//       'AUTH-TOKEN': loginService.getToken()
//      });
// console.log(header);
//      const clnreq =  req.clone({header})
//     // let tokenizedReq = req.clone({
      // setHeaders:{
      //   Authorization: `Bearer ${loginService.getToken()}` 
      // }
    //    headers: new HttpHeaders({
    //     'Authorization': `Bearer ${loginService.getToken()}`
    //    })
    // });
    return next.handle(req);
}
}
