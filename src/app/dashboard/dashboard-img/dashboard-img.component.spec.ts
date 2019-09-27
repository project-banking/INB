import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardImgComponent } from './dashboard-img.component';

describe('DashboardImgComponent', () => {
  let component: DashboardImgComponent;
  let fixture: ComponentFixture<DashboardImgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardImgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardImgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
