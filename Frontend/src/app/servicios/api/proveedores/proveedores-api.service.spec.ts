import { TestBed } from '@angular/core/testing';

import { ProveedoresApiService } from './proveedores-api.service';

describe('ProveedoresApiService', () => {
  let service: ProveedoresApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProveedoresApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
