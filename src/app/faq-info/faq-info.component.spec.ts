import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FaqInfoComponent } from './faq-info.component';

describe('FaqInfoComponent', () => {
  let component: FaqInfoComponent;
  let fixture: ComponentFixture<FaqInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FaqInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FaqInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
