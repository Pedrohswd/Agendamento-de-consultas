import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadeCreateComponent } from './unidade-create.component';

describe('UnidadeCreateComponent', () => {
  let component: UnidadeCreateComponent;
  let fixture: ComponentFixture<UnidadeCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadeCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnidadeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
