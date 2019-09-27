import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmindashboardNavComponent } from './admindashboard-nav.component';

describe('AdmindashboardNavComponent', () => {
  let component: AdmindashboardNavComponent;
  let fixture: ComponentFixture<AdmindashboardNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmindashboardNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmindashboardNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
