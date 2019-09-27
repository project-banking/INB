import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindashboard-nav',
  templateUrl: './admindashboard-nav.component.html',
  styleUrls: ['./admindashboard-nav.component.css']
})
export class AdmindashboardNavComponent implements OnInit {

  constructor(private router: Router) { }

  onClickMe(){
    localStorage.removeItem('token');
  this.router.navigate(['login']);
  }
  ngOnInit() {
  }

}
