import { Component, OnInit } from '@angular/core';
import { SidenavserviceService } from '../sidenavservice.service';

@Component({
  selector: 'app-dashboard-sidebar',
  templateUrl: './dashboard-sidebar.component.html',
  styleUrls: ['./dashboard-sidebar.component.css']
})
export class DashboardSidebarComponent implements OnInit {

  isOpen: boolean;

  constructor(private sidenavservice : SidenavserviceService) {
    this.sidenavservice.isSideNavOpen.subscribe(
      (isSideNavOpen: boolean) => {
        return this.isOpen = isSideNavOpen;
      }
    );
  }

  ngOnInit() {
  }

  closeNav() {
    this.sidenavservice.closeNav();
  }
  openNav() {
    this.sidenavservice.openNav();
  }

}
