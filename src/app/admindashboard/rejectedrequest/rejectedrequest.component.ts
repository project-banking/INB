import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-rejectedrequest',
  templateUrl: './rejectedrequest.component.html',
  styleUrls: ['./rejectedrequest.component.css']
})
export class RejectedrequestComponent implements OnInit {
  user : []
  constructor(private admindashboardService: AdmindashboardService, private activeRouter : ActivatedRoute) { }

  ngOnInit() {
  }
  approved(id: number){
    console.log(id)
    this.admindashboardService.approveduser(id).subscribe((res) =>{
      console.log("apprved");
    })
  }
  getallcustomer(){
    this.activeRouter.params.subscribe(data =>{
      this.admindashboardService.getrejectedcustomer().subscribe(
        (res:any) => this.user = res,
        error => console.error()
        
      );
    });
 }

}
