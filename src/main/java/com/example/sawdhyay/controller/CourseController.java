package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.Course;
import com.example.sawdhyay.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value="/courses", method = RequestMethod.GET)
    public String getCourses(Model model){
        model.addAttribute("courses", this.courseService.findAllCourses());
        return "courses";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course){
        this.courseService.addCourse(course);
        return  "redirect:/courses";
    }

    @RequestMapping(value="/courses/{id}", method = RequestMethod.GET)
    public String getCourse(@PathVariable int id, Model model){
        model.addAttribute("course", this.courseService.getCourseById(id));
        return "courses";
    }

    @RequestMapping(value="/courses/{id}", method = RequestMethod.PATCH)
    public String updateCourse(@PathVariable int id, @ModelAttribute("course") Course course){
        this.courseService.updateCourse(course);
        return "redirect:/courses";
    }

    @RequestMapping(value="/courses/{id}", method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable int id){
        this.courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}
