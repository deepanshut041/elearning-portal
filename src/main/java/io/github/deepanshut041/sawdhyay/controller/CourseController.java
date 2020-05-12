package io.github.deepanshut041.sawdhyay.controller;

import io.github.deepanshut041.sawdhyay.models.Course;
import io.github.deepanshut041.sawdhyay.models.Enrollment;
import io.github.deepanshut041.sawdhyay.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public ModelAndView coursesPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Course> courses = courseService.findAllCourses();
        modelAndView.addObject("courses", courses);
        modelAndView.setViewName("courses");
        return modelAndView;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ModelAndView getCourse(@PathVariable int id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Enrollment enrollment = new Enrollment();
        modelAndView.addObject("course", this.courseService.getCourseById(id));
        modelAndView.addObject("enrollments", enrollment);
        modelAndView.setViewName("course");
        return modelAndView;
    }

}
