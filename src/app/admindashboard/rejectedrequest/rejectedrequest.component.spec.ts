import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RejectedrequestComponent } from './rejectedrequest.component';

describe('RejectedrequestComponent', () => {
  let component: RejectedrequestComponent;
  let fixture: ComponentFixture<RejectedrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RejectedrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RejectedrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
