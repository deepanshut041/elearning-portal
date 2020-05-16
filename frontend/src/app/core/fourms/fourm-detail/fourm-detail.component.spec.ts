import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FourmDetailComponent } from './fourm-detail.component';

describe('FourmDetailComponent', () => {
  let component: FourmDetailComponent;
  let fixture: ComponentFixture<FourmDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FourmDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FourmDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
