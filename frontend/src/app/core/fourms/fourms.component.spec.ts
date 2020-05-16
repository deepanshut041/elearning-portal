import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FourmsComponent } from './fourms.component';

describe('FourmsComponent', () => {
  let component: FourmsComponent;
  let fixture: ComponentFixture<FourmsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FourmsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FourmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
