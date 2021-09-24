import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CraerDisponibilidadComponent } from './craer-disponibilidad.component';

describe('CraerDisponibilidadComponent', () => {
  let component: CraerDisponibilidadComponent;
  let fixture: ComponentFixture<CraerDisponibilidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CraerDisponibilidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CraerDisponibilidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
