package com.example.sawdhyay.controller;


import com.example.sawdhyay.models.Fanswer;
import com.example.sawdhyay.models.Fquestion;
import com.example.sawdhyay.services.FanswerService;
import com.example.sawdhyay.services.FquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/fourms")
public class FourmController {

    @Autowired
    private FquestionService fquestionService;

    @Autowired
    private FanswerService fanswerService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView froumsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Fquestion> fquestions = this.fquestionService.findAllFquestions();
        modelAndView.addObject("questions", fquestions);
        modelAndView.setViewName("fourms");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView froumPage(@PathVariable int id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Fquestion fquestion = this.fquestionService.getFquestionById(id);
        List<Fanswer> fanswers = this.fanswerService.findAllFanswers();
        Fanswer fanswer = new Fanswer();
        modelAndView.addObject("question", fquestion);
        modelAndView.addObject("answers", fanswers);
        modelAndView.addObject("fanswer", fanswer);
        modelAndView.setViewName("fourm");
        return modelAndView;
    }

}
