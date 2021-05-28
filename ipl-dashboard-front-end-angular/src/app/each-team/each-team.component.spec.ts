import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EachTeamComponent } from './each-team.component';

describe('EachTeamComponent', () => {
  let component: EachTeamComponent;
  let fixture: ComponentFixture<EachTeamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EachTeamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EachTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
