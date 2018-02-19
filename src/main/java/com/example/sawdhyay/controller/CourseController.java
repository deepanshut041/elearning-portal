package com.example.sawdhyay.controller;

import com.example.sawdhyay.repositories.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    private CourseRepository courseRepository;
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @RequestMapping("/courses")
    public String getCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

}
