package com.example.sawdhyay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @RequestMapping(value = {"/", "", "/courses"}, method = RequestMethod.GET)
    public ModelAndView classroomPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView classroomSettingPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-settings");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ModelAndView classroomCoursePage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        return modelAndView;
    }

}

