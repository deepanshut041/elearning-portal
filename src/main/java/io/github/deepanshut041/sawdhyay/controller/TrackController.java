package io.github.deepanshut041.sawdhyay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tracks")
public class TrackController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView tracksPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tracks");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView trackPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("track");
        return modelAndView;
    }

}
