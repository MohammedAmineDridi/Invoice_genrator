import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { SigninComponent } from './signin/signin.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { EmployeesComponent } from './employees/employees.component';
import { VaccationsComponent } from './vaccations/vaccations.component';

import { MeetingsComponent } from './meetings/meetings.component';

import { RecrutementsComponent } from './recrutements/recrutements.component';

import { TodoListComponent } from './todo-list/todo-list.component';

import { BudgetsComponent } from './budgets/budgets.component';

import { TimeTrackingComponent } from './time-tracking/time-tracking.component';

import { AnnoncementsComponent } from './annoncements/annoncements.component';

import { SettingsComponent } from './settings/settings.component';







const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'signin',component:SigninComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'employees',component:EmployeesComponent},
  {path:'vaccations',component:VaccationsComponent},
  {path:'mettings',component:MeetingsComponent},
  {path:'recrutements',component:RecrutementsComponent},
  {path:'todoList',component:TodoListComponent},
  {path:'budgets',component:BudgetsComponent},
  {path:'timetracking',component:TimeTrackingComponent},
  {path:'annoncements',component:AnnoncementsComponent},
  {path:'settings',component:SettingsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponent = [LoginComponent,SigninComponent,
  DashboardComponent,EmployeesComponent,VaccationsComponent,
  MeetingsComponent,RecrutementsComponent,TodoListComponent,
  BudgetsComponent,TimeTrackingComponent,AnnoncementsComponent,
  SettingsComponent] 

