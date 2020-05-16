import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FourmsListComponent } from './fourms-list.component';

describe('FourmsListComponent', () => {
  let component: FourmsListComponent;
  let fixture: ComponentFixture<FourmsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FourmsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FourmsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
