import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-img',
  templateUrl: './dashboard-img.component.html',
  styleUrls: ['./dashboard-img.component.css']
})
export class DashboardImgComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit() {
  }

}
