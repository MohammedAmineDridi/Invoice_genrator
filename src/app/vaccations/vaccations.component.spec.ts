import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccationsComponent } from './vaccations.component';

describe('VaccationsComponent', () => {
  let component: VaccationsComponent;
  let fixture: ComponentFixture<VaccationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VaccationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
