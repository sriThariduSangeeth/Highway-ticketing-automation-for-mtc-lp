import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CounterComponent } from './counter/counter.component';

import {HomeComponent} from './home/home.component';
import {RegisterComponent} from './register/register.component';
import { StaticsComponent } from './statics/statics.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'counter', component: CounterComponent},
  {path:'statics', component: StaticsComponent},
  {path:'register', component: RegisterComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
