import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionarioUpdateComponent } from './funcionario-update.component';

describe('FuncionarioUpdateComponent', () => {
  let component: FuncionarioUpdateComponent;
  let fixture: ComponentFixture<FuncionarioUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuncionarioUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuncionarioUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
