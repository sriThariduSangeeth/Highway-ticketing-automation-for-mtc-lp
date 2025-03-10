import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts'; 

@Component({
  selector: 'app-widget-areachart',
  templateUrl: './areachart.component.html',
  styleUrls: ['./areachart.component.css']
})
export class AreachartComponent implements OnInit {

  chartOptions!: {};
  Highcharts = Highcharts;

  constructor() { }

  ngOnInit(): void {

    this.chartOptions = {
      chart: {
          type: 'area',
          backgroundColor: null,
          className: 'mat1-app-background'
      },
      title: {
          text: 'Historic and Estimated Worldwide Population Growth by Region'
      },
      subtitle: {
          text: 'Source: Wikipedia.org'
      },
      xAxis: {
          categories: ['1750', '1800', '1850', '1900', '1950', '1999', '2050'],
          tickmarkPlacement: 'on',
          title: {
              enabled: false
          }
      },
      tooltip: {
          split: true,
          valueSuffix: ' millions'
      },
      series: [{
          name: 'Asia',
          data: [502, 635, 809, 947, 1402, 3634, 5268]
      }, {
          name: 'Africa',
          data: [106, 107, 111, 133, 221, 767, 1766]
      }, {
          name: 'Europe',
          data: [163, 203, 276, 408, 547, 729, 628]
      }, {
          name: 'America',
          data: [18, 31, 54, 156, 339, 818, 1201]
      }, {
          name: 'Oceania',
          data: [2, 2, 2, 6, 13, 30, 46]
      }]
  }
  }

}
