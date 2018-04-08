package com.example.sawdhyay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView blogsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blogs");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView blogPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog");
        return modelAndView;
    }



}
