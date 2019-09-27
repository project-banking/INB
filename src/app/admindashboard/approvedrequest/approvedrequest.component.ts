import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-approvedrequest',
  templateUrl: './approvedrequest.component.html',
  styleUrls: ['./approvedrequest.component.css']
})
export class ApprovedrequestComponent implements OnInit {
  user : []
  constructor(private admindashboardService: AdmindashboardService, private activeRouter : ActivatedRoute) { }

  ngOnInit() {
  }
  status(a){

  }
  getallcustomer(){
    this.activeRouter.params.subscribe(data =>{
      this.admindashboardService.getapprovedcustomer().subscribe(
        (res:any) => this.user = res,
        
        error => console.error()
       
        )
    //  this.status(res);
    });
    

 }

}
