import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicoUpdateComponent } from './medico-update.component';

describe('MedicoUpdateComponent', () => {
  let component: MedicoUpdateComponent;
  let fixture: ComponentFixture<MedicoUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicoUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
