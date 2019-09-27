import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {
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

  reject(id: number){
    this.admindashboardService.updateuser(id).subscribe((res) =>{
      console.log("rejected");
    })
  }
  getallcustomer(){
   this.activeRouter.params.subscribe(data =>{
     this.admindashboardService.getcustomer().subscribe(
       (res:any) => this.user = res,
       error => console.error()
       
     );
   });
}
}
