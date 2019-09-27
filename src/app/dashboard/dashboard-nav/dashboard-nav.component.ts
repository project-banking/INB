import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-nav',
  templateUrl: './dashboard-nav.component.html',
  styleUrls: ['./dashboard-nav.component.css']
})
export class DashboardNavComponent implements OnInit {

  constructor(private router: Router) { }
  onClickMe(){
    localStorage.removeItem('token');
  this.router.navigate(['login']);
  }
  ngOnInit() {
  }

}
