import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { CoreComponent } from './core.component';
import { RouterModule } from '@angular/router';
import { BlogsComponent } from './blogs/blogs.component';
import { BlogListComponent } from './blogs/blog-list/blog-list.component';
import { BlogDetailComponent } from './blogs/blog-detail/blog-detail.component';
import { CoursesComponent } from './courses/courses.component';
import { TracksComponent } from './tracks/tracks.component';
import { CourseComponent } from './course/course.component';
import { TrackComponent } from './track/track.component';
import { FourmsComponent } from './fourms/fourms.component';
import { FourmsListComponent } from './fourms/fourms-list/fourms-list.component';
import { FourmDetailComponent } from './fourms/fourm-detail/fourm-detail.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [HomeComponent, CoreComponent, BlogsComponent, BlogListComponent,
     BlogDetailComponent, CoursesComponent, TracksComponent, CourseComponent,
      TrackComponent, FourmsComponent, FourmsListComponent, FourmDetailComponent],
  imports: [
    CommonModule, RouterModule, SharedModule
  ]
})
export class CoreModule { }
