package com.example.sawdhyay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fourms")
public class FourmController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView froumsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fourms");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView froumPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fourm");
        return modelAndView;
    }

}
