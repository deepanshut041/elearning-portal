package com.example.sawdhyay.controller;


import com.example.sawdhyay.models.*;
import com.example.sawdhyay.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
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

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView froumsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Fquestion> fquestions = this.fquestionService.findAllFquestions();
        modelAndView.addObject("questions", fquestions);
        modelAndView.setViewName("fourms");
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView froumsaddPage(Model model){
        try{
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            Student student = studentService.getStudentByUserId(user.getId());
            if (student == null){
                return new ModelAndView(new RedirectView("/classroom/settings"));
            }
        }
        catch (Exception exception){
            return new ModelAndView(new RedirectView("/classroom/settings"));
        }
        ModelAndView modelAndView = new ModelAndView();
        Fquestion fquestion = new Fquestion();
        List<Category> categories = categoryService.findAllCategorys();
        List<Language> languages = languageService.findAllLanguages();
        modelAndView.addObject("fquestion", fquestion);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("languages", languages);
        modelAndView.setViewName("add-fourm");
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView froumspostPage(@Valid Fquestion fquestion, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            Student student = studentService.getStudentByUserId(user.getId());
            if (student == null){
                return new ModelAndView(new RedirectView("/classroom/settings"));
            }
            modelAndView.addObject("fquestion", fquestion);

        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            Student student = studentService.getStudentByUserId(user.getId());
            if (student == null){
                return new ModelAndView(new RedirectView("/classroom/settings"));
            }
            Student student1 = new Student();
            student1.setId(student.getId());
            if(fquestion.getId() == 0) {
                fquestion.setStudent(student1);
                fquestionService.addFquestion(fquestion);
                modelAndView.addObject("successMessage", "Query has been added successfully");
            }
            else {
                fquestionService.addFquestion(fquestion);
                modelAndView.addObject("successMessage", "Query has been updated successfully");
            }
            Fquestion fquestion1 = new Fquestion();
            modelAndView.addObject("fquestion", fquestion1);

        }
        List<Category> categories = categoryService.findAllCategorys();
        List<Language> languages = languageService.findAllLanguages();
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("languages", languages);
        modelAndView.setViewName("add-fourm");
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

    @RequestMapping(value = "/{id}/answer", method = RequestMethod.POST)
    public ModelAndView froumAnswerPage(@PathVariable int id,@Valid Fanswer fanswer, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            return new ModelAndView(new RedirectView("/fourms/" + id));
        }else{
            Fquestion fquestion = new Fquestion();
            fquestion.setId(id);
            fanswer.setFquestion(fquestion);
            fanswerService.addFanswer(fanswer);
        }

        return new ModelAndView(new RedirectView("/fourms/" + id));
    }

}
