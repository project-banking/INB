import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeimgComponent } from './homeimg.component';

describe('HomeimgComponent', () => {
  let component: HomeimgComponent;
  let fixture: ComponentFixture<HomeimgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeimgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeimgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
