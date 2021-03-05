import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import factory from 'highcharts/modules/map';

@Component({
  selector: 'app-widget-cardchart',
  templateUrl: './widget-cardchart.component.html',
  styleUrls: ['./widget-cardchart.component.css']
})
export class WidgetCardchartComponent implements OnInit {

  chartOptions!: {};
  Highcharts = Highcharts;
  constructor() { }

  ngOnInit(): void {
    this.chartOptions = {
      chart: {
        type: 'area',
        backgroundColor: null,
        borderWidth: 0,
        margin: [2, 2, 2, 2],
        height: 60
      },
      title: {
        text: null
      },
      subtitle: {
        text: null
      },
      tooltip: {
        split: true,
        outside: true
      },
      legend: {
        enabled: false
      },
      credits: {
        enabled: false
      },
      exporting: [{
        enabled: false
      }],
      xAxis: {
        labels: {
          enabled: false
        },
        title: {
          enabled: false
        }
      }
      , series: [{
        data: [502, 635, 809, 947, 1402, 3634, 5268]
      }]
    };
  }

}
