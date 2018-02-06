package com.example.sawdhyay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String mainPage() {
        return "home";
    }

    @RequestMapping("/signin")
    public String signinPage() {
        return "signin";
    }

    @RequestMapping("/signup")
    public String signupPage() {
        return "signup";
    }
}
