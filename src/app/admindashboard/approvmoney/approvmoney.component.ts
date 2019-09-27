import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-approvmoney',
  templateUrl: './approvmoney.component.html',
  styleUrls: ['./approvmoney.component.css']
})
export class ApprovmoneyComponent implements OnInit {
transaction : {}
  constructor(private admindashboardService: AdmindashboardService, private activeRouter : ActivatedRoute,private router:Router) { }

  ngOnInit() {
  }

  approved(id: number){
    console.log(id)
    this.admindashboardService.approvedtransaction(id).subscribe((res) =>{
      alert("mponey request approved")
      this.router.navigate(['admindashboard/admindashboard'])
    })
  }

  reject(id: number){
    this.admindashboardService.updateusertransaction(id).subscribe((res) =>{
      console.log("rejected");
    })
  }
  getallcustomertransaction(){
    console.log("work")

    this.admindashboardService.getcustomertransaction().subscribe( res => {
      this.transaction = res;
      console.log(this.transaction);
    }, 
      error =>{console.log(error);
      } 
    );
    // this.activeRouter.params.subscribe(data =>{
    //   debugger
     
    // });
    
 }
}
