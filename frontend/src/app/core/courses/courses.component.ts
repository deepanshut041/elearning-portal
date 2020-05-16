import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses: number[] = []

  constructor() { }

  ngOnInit(): void {
    for (let i = 0; i < 10; i++) {
      this.courses.push(i)
      
    }
  }

}
