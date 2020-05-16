import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './core/home/home.component';
import { CoreComponent } from './core/core.component';
import { CoursesComponent } from './core/courses/courses.component';

const routes: Routes = [
  {
    path: '', component: CoreComponent, children: [
      { path: '', component: HomeComponent },
      { path: 'courses', component: CoursesComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
