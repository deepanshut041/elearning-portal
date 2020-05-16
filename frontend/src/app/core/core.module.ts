import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { CoreComponent } from './core.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [HomeComponent, CoreComponent],
  imports: [
    CommonModule, RouterModule
  ]
})
export class CoreModule { }
