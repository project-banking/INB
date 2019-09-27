import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailstatementComponent } from './detailstatement.component';

describe('DetailstatementComponent', () => {
  let component: DetailstatementComponent;
  let fixture: ComponentFixture<DetailstatementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailstatementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailstatementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
