import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministradorUpdateComponent } from './administrador-update.component';

describe('AdministradorUpdateComponent', () => {
  let component: AdministradorUpdateComponent;
  let fixture: ComponentFixture<AdministradorUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministradorUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdministradorUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
