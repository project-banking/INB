import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-pendingrequest',
  templateUrl: './pendingrequest.component.html',
  styleUrls: ['./pendingrequest.component.css']
})
export class PendingrequestComponent implements OnInit {
  user : []
  constructor(private admindashboardService: AdmindashboardService, private activeRouter : ActivatedRoute,private router: Router) { }



  ngOnInit() {
  }

  approved(id: number){
    console.log(id)
    this.admindashboardService.approveduser(id).subscribe((res) =>{
      alert("request approved")
      this.router.navigate(['admindashboard/admindashboard'])
    })
  }

  reject(id: number){
    this.admindashboardService.updateuser(id).subscribe((res) =>{
    alert("request rejected")
    this.router.navigate(['admindashboard/admindashboard'])
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
