package com.example.sawdhyay.controller;


import com.example.sawdhyay.models.*;
import com.example.sawdhyay.services.*;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CategoryService categoryService;



    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView froumsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Fquestion> fquestions = this.fquestionService.findAllFquestions();
        modelAndView.addObject("questions", fquestions);
        modelAndView.setViewName("fourms");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView froumsaddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Fquestion fquestion = new Fquestion();
        List<Category> categories = categoryService.findAllCategorys();
        List<Language> languages = languageService.findAllLanguages();
        modelAndView.addObject("fquestion", fquestion);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("languages", languages);
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
