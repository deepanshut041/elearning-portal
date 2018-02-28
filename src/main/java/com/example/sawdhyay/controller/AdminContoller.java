package com.example.sawdhyay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model){
        return "admin-home";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String coursesPage(Model model){
        return "admin-courses";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogPage(Model model){
        return "admin-blog";
    }
}
