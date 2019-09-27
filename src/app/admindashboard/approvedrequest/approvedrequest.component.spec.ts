import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedrequestComponent } from './approvedrequest.component';

describe('ApprovedrequestComponent', () => {
  let component: ApprovedrequestComponent;
  let fixture: ComponentFixture<ApprovedrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApprovedrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
