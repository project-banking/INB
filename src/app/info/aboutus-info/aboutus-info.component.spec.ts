import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutusInfoComponent } from './aboutus-info.component';

describe('AboutusInfoComponent', () => {
  let component: AboutusInfoComponent;
  let fixture: ComponentFixture<AboutusInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutusInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutusInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
