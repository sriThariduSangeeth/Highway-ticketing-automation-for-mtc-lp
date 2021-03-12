import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import {ScrollingModule} from '@angular/cdk/scrolling';
import {CdkStepperModule} from '@angular/cdk/stepper';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './home/home.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { NgxMatFileInputModule } from '@angular-material-components/file-input';
import { LoginComponent } from './login/login.component';
import { CounterComponent } from './counter/counter.component';
import { StaticsComponent } from './statics/statics.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTabsModule} from '@angular/material/tabs';
import { AuthGuard } from './guards/auth.guard';
import { AuthService } from './services/auth.service';
import { TokenInterceptor } from './interceptor/token.interceptor';
import { MainComponent } from './main/main.component';
import{FlexLayoutModule} from '@angular/flex-layout';
import { AreachartComponent } from './shared/widget/areachart/areachart.component';
import { HighchartsChartModule } from 'highcharts-angular';
import { WidgetCardchartComponent } from './shared/widget/widget-cardchart/widget-cardchart.component';
import { WidgetPiechartComponent } from './shared/widget/widget-piechart/widget-piechart.component';
import { DriveraddComponent } from './register/driveradd/driveradd.component';
import { VehicleaddComponent } from './register/vehicleadd/vehicleadd.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    CounterComponent,
    StaticsComponent,
    MainComponent,
    AreachartComponent,
    WidgetCardchartComponent,
    WidgetPiechartComponent,
    DriveraddComponent,
    VehicleaddComponent
  ],
  imports: [
    BrowserModule,
    ScrollingModule,
    CdkStepperModule,
    CdkTableModule,
    CdkTreeModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    NgxMatFileInputModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatSlideToggleModule,
    MatMenuModule,
    HttpClientModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatTabsModule,
    FlexLayoutModule,
    HighchartsChartModule,
  ],
  providers: [
    AuthGuard,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
