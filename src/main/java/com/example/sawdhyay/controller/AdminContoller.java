package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.Category;
import com.example.sawdhyay.models.Course;
import com.example.sawdhyay.models.Language;
import com.example.sawdhyay.services.CategoryService;
import com.example.sawdhyay.services.CourseService;
import com.example.sawdhyay.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CourseService courseService;


    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model){
        return "admin-home";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String coursePage(Model model){
        return "admin-courses";
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.GET)
    public ModelAndView courseAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = new Course();
        modelAndView.addObject("course", course);
        modelAndView.addObject("categorys", this.categoryService.findAllCategorys());
        modelAndView.addObject("languages", this.languageService.findAllLanguages());
        modelAndView.setViewName("admin-course-add");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.POST)
    public ModelAndView createNewCourse(@Valid Course course, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("categorys", this.categoryService.findAllCategorys());
            modelAndView.addObject("languages", this.languageService.findAllLanguages());
            modelAndView.setViewName("admin-course-add");
        } else {
            courseService.addCourse(course);
            modelAndView.addObject("successMessage", "Course has been added successfully");
            modelAndView.addObject("course", new Course());
            modelAndView.addObject("categorys", this.categoryService.findAllCategorys());
            modelAndView.addObject("languages", this.languageService.findAllLanguages());
            modelAndView.setViewName("admin-course-add");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/language/add", method = RequestMethod.GET)
    public ModelAndView languageAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Language language = new Language();
        modelAndView.addObject("language", language);
        modelAndView.setViewName("admin-language-add");
        return modelAndView;
    }

    @RequestMapping(value = "/language/add", method = RequestMethod.POST)
    public ModelAndView createNewLanguage(@Valid Language language, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin-language-add");
        } else {
            languageService.addLanguage(language);
            modelAndView.addObject("successMessage", "Language has been added successfully");
            modelAndView.addObject("language", new Language());
            modelAndView.setViewName("admin-language-add");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.GET)
    public ModelAndView categoryAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Category category = new Category();
        modelAndView.addObject("category", category);
        modelAndView.setViewName("admin-category-add");
        return modelAndView;
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public ModelAndView createNewCategory(@Valid Category category, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin-category-add");
        } else {
            categoryService.addCategory(category);
            modelAndView.addObject("successMessage", "Category has been added successfully");
            modelAndView.addObject("category", new Category());
            modelAndView.setViewName("admin-category-add");

        }
        return modelAndView;
    }



    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogPage(Model model){
        return "admin-blog";
    }
}
