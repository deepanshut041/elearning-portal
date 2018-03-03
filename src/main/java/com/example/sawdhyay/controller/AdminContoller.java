package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.*;
import com.example.sawdhyay.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private StepService stepService;


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

    @RequestMapping(value = "/courses/{course_id}/modules", method = RequestMethod.GET)
    public ModelAndView courseModulesPage(@PathVariable int course_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        Module module = new Module();
        modelAndView.addObject("course", course);
        modelAndView.addObject("module", module);
        modelAndView.setViewName("admin-course-module");
        return modelAndView;
    }


    @RequestMapping(value = "/courses/{course_id}/modules", method = RequestMethod.POST)
    public ModelAndView createNewModule(@Valid Module module, BindingResult bindingResult, @PathVariable int course_id) {
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        module.setCourse(course);
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("course", course);
            modelAndView.setViewName("admin-course-module");
        } else {
            if(module.getId() == 0) {
                moduleService.addModule(module);
            }
            else {
                moduleService.updateModule(module);
            }
            course = courseService.getCourseById(course_id);
            modelAndView.addObject("successMessage", "Module has been added successfully");
            modelAndView.addObject("module", new Module());
            modelAndView.addObject("course", course);
            modelAndView.setViewName("admin-course-module");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/edit", method = RequestMethod.GET)
    public ModelAndView courseModulesEditPage(@PathVariable int course_id, @PathVariable int module_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        Module module = moduleService.getModuleById(module_id);
        modelAndView.addObject("course", course);
        modelAndView.addObject("module", module);
        modelAndView.setViewName("admin-course-module");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/delete", method = RequestMethod.GET)
    public String courseModulesDelete(@PathVariable int course_id, @PathVariable int module_id, Model model){
        this.moduleService.deleteModuleById(module_id);
        return "redirect:/admin/courses/" + course_id + "/modules";
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/steps", method = RequestMethod.GET)
    public ModelAndView courseModulesStepPage(@PathVariable int course_id, @PathVariable int module_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        Module module = this.moduleService.getModuleById(module_id);
        Step step = new Step();
        modelAndView.addObject("course", course);
        modelAndView.addObject("module", module);
        modelAndView.addObject("step", step);
        modelAndView.setViewName("admin-course-step");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/steps", method = RequestMethod.POST)
    public ModelAndView createNewStep(@Valid Step step, BindingResult bindingResult, @PathVariable int course_id, @PathVariable int module_id) {
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        Module module = this.moduleService.getModuleById(module_id);
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("course", course);
            modelAndView.addObject("module", module);
            modelAndView.setViewName("admin-course-step");
        } else {
            stepService.addStep(step);
            modelAndView.addObject("successMessage", "Step has been added successfully");
            modelAndView.addObject("course", course);
            modelAndView.addObject("module", module);
            modelAndView.addObject("step", new Step());
            modelAndView.setViewName("admin-course-step");

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
