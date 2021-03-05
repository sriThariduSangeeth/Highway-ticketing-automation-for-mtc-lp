import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WidgetCardchartComponent } from './widget-cardchart.component';

describe('WidgetCardchartComponent', () => {
  let component: WidgetCardchartComponent;
  let fixture: ComponentFixture<WidgetCardchartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WidgetCardchartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WidgetCardchartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
