import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionarioCreateComponent } from './funcionario-create.component';

describe('FuncionarioCreateComponent', () => {
  let component: FuncionarioCreateComponent;
  let fixture: ComponentFixture<FuncionarioCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuncionarioCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuncionarioCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
