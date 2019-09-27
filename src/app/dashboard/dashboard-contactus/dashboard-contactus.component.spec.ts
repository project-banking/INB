import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardContactusComponent } from './dashboard-contactus.component';

describe('DashboardContactusComponent', () => {
  let component: DashboardContactusComponent;
  let fixture: ComponentFixture<DashboardContactusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardContactusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardContactusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
