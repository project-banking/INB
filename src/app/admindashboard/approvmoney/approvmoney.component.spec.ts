import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovmoneyComponent } from './approvmoney.component';

describe('ApprovmoneyComponent', () => {
  let component: ApprovmoneyComponent;
  let fixture: ComponentFixture<ApprovmoneyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApprovmoneyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovmoneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
