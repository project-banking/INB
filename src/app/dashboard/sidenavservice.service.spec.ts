import { TestBed } from '@angular/core/testing';

import { SidenavserviceService } from './sidenavservice.service';

describe('SidenavserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SidenavserviceService = TestBed.get(SidenavserviceService);
    expect(service).toBeTruthy();
  });
});
