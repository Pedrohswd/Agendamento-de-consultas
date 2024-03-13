import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadeUpdateComponent } from './unidade-update.component';

describe('UnidadeUpdateComponent', () => {
  let component: UnidadeUpdateComponent;
  let fixture: ComponentFixture<UnidadeUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadeUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnidadeUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
