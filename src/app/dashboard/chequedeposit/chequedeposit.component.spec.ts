import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequedepositComponent } from './chequedeposit.component';

describe('ChequedepositComponent', () => {
  let component: ChequedepositComponent;
  let fixture: ComponentFixture<ChequedepositComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChequedepositComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequedepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
