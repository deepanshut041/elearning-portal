package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.*;
import com.example.sawdhyay.services.*;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

    @Autowired
    private  PostService postService;

    @Autowired
    private PcategoryService pcategoryService;
    
    @Autowired
    private TrackService trackService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private UserService userService;



    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homePage(Model model){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin-home");
        return modelAndView;
    }

    // Course handle goes here

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView coursesPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Course> courses = courseService.findAllCourses();
        modelAndView.addObject("courses", courses);
        modelAndView.setViewName("admin-courses");
        return modelAndView;
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
            if(course.getId() == 0) {
                courseService.addCourse(course);
            }
            else {
                courseService.updateCourse(course);
            }
            modelAndView.addObject("successMessage", "Course has been added successfully");
            modelAndView.addObject("course", new Course());
            modelAndView.addObject("categorys", this.categoryService.findAllCategorys());
            modelAndView.addObject("languages", this.languageService.findAllLanguages());
            modelAndView.setViewName("admin-course-add");

        }
        return modelAndView;
    }
    @RequestMapping(value = "/courses/{course_id}/edit", method = RequestMethod.GET)
    public ModelAndView courseEditPage(@PathVariable int course_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        modelAndView.addObject("course", course);
        modelAndView.addObject("categorys", this.categoryService.findAllCategorys());
        modelAndView.addObject("languages", this.languageService.findAllLanguages());
        modelAndView.setViewName("admin-course-add");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/delete", method = RequestMethod.GET)
    public String courseDelete(@PathVariable int course_id, Model model){
        this.courseService.deleteCourseById(course_id);
        return "redirect:/admin/courses";
    }

    // Module handlers goes here

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

    // Steps Handlers goes here

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
        step.setModule(module);
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("course", course);
            modelAndView.addObject("module", module);
            modelAndView.setViewName("admin-course-step");
        } else {
            if(step.getId() == 0) {
                stepService.addStep(step);
            }
            else {
                stepService.updateStep(step);
            }
            course = courseService.getCourseById(course_id);
            module = this.moduleService.getModuleById(module_id);
            modelAndView.addObject("successMessage", "Step has been added successfully");
            modelAndView.addObject("course", course);
            modelAndView.addObject("module", module);
            modelAndView.addObject("step", new Step());
            modelAndView.setViewName("admin-course-step");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/steps/{step_id}/edit", method = RequestMethod.GET)
    public ModelAndView courseStepEditPage(@PathVariable int course_id, @PathVariable int module_id, @PathVariable int step_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Course course = courseService.getCourseById(course_id);
        Module module = this.moduleService.getModuleById(module_id);
        Step step = this.stepService.getStepById(step_id);
        modelAndView.addObject("course", course);
        modelAndView.addObject("module", module);
        modelAndView.addObject("step", step);
        modelAndView.setViewName("admin-course-step");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{course_id}/modules/{module_id}/steps/{step_id}/delete", method = RequestMethod.GET)
    public String courseStepDelete(@PathVariable int course_id, @PathVariable int module_id,@PathVariable int step_id, Model model){
        this.stepService.deleteStepById(step_id);
        return "redirect:/admin/courses/" + course_id + "/modules/" + module_id + "/steps";
    }

    // Language handlers goes here

    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public ModelAndView languagesPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Language language = new Language();
        modelAndView.addObject("language", language);
        modelAndView.setViewName("admin-language");
        return modelAndView;
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public ModelAndView createNewLanguage(@Valid Language language, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin-language");
        } else {
            if(language.getId() != 0){
                languageService.updateLanguage(language);
            }
            else {
                languageService.addLanguage(language);
            }
            modelAndView.addObject("successMessage", "Language has been added successfully");
            modelAndView.addObject("language", new Language());
            modelAndView.setViewName("admin-language");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/languages/{language_id}/edit", method = RequestMethod.GET)
    public ModelAndView languageEditPage(@PathVariable int language_id, Model model){
        Language language = this.languageService.getLanguageById(language_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("language", language);
        modelAndView.setViewName("admin-language");
        return modelAndView;
    }

    @RequestMapping(value = "/languages/{language_id}/delete", method = RequestMethod.GET)
    public String languageDelete(@PathVariable int language_id, Model model){
        this.languageService.deleteLanguageById(language_id);
        return "redirect:/admin/languages";
    }

    // Category Handlers goes here

    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public ModelAndView categoryAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Category category = new Category();
        List<Category> categories = this.categoryService.findAllCategorys();
        modelAndView.addObject("category", category);
        modelAndView.addObject("categorys", categories);
        modelAndView.setViewName("admin-category");
        return modelAndView;
    }

    @RequestMapping(value = "/categorys", method = RequestMethod.POST)
    public ModelAndView createNewCategory(@Valid Category category, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Category> categories = this.categoryService.findAllCategorys();
            modelAndView.addObject("categorys", categories);
            modelAndView.setViewName("admin-category");
        } else {
            categoryService.addCategory(category);
            modelAndView.addObject("successMessage", "Category has been added successfully");
            List<Category> categories = this.categoryService.findAllCategorys();
            modelAndView.addObject("categorys", categories);
            modelAndView.addObject("category", new Category());
            modelAndView.setViewName("admin-category");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/categorys/{category_id}/edit", method = RequestMethod.GET)
    public ModelAndView categoryEditPage(@PathVariable int category_id, Model model){
        Category category = this.categoryService.getCategoryById(category_id);
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = this.categoryService.findAllCategorys();
        modelAndView.addObject("categorys", categories);
        modelAndView.addObject("category", category);
        modelAndView.setViewName("admin-category");
        return modelAndView;
    }

    @RequestMapping(value = "/categorys/{category_id}/delete", method = RequestMethod.GET)
    public String categoryDelete(@PathVariable int category_id, Model model){
        this.categoryService.deleteCategoryById(category_id);
        return "redirect:/admin/categorys";
    }



    // Blog Handlers goes here

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ModelAndView blogPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Post> posts = this.postService.findAllPosts();
        modelAndView.addObject("posts", posts);
        modelAndView.setViewName("admin-blog");
        return (modelAndView);
    }


    @RequestMapping(value = "/blogs/add", method = RequestMethod.GET)
    public ModelAndView blogAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        List<Pcategory> pcategories = pcategoryService.findAllPcategorys();
        modelAndView.addObject("pcategorys", pcategories);
        modelAndView.addObject("post", post);
        modelAndView.addObject("category", new Pcategory());
        modelAndView.setViewName("admin-add-blog");
        return modelAndView;
    }

    @RequestMapping(value = "/blogs/add", method = RequestMethod.POST)
    public ModelAndView createNewBlog(@Valid Post post, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Pcategory> pcategories = pcategoryService.findAllPcategorys();
        modelAndView.addObject("pcategorys", pcategories);
        modelAndView.addObject("category", new Pcategory());
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin-add-blog");
        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            Mentor mentor = mentorService.getMentorByUserId(user.getId());
            post.setMentor(mentor);
            if(post.getId() == 0) {
                postService.addPost(post);
            }
            else {
                postService.updatePost(post);
            }
            modelAndView.addObject("successMessage", "Post has been added successfully");
            modelAndView.addObject("post", new Post());
            modelAndView.setViewName("admin-add-blog");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/blogs/category/add", method = RequestMethod.POST)
    public ModelAndView createNewPCategory(@Valid Pcategory pcategory, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Pcategory> pcategories = pcategoryService.findAllPcategorys();
            modelAndView.addObject("post", new Post());
            modelAndView.addObject("pcategorys", pcategories);
            modelAndView.setViewName("admin-add-blog");
        } else {
            if(pcategory.getId() == 0) {
                pcategoryService.addPcategory(pcategory);
            }
            else {
                pcategoryService.addPcategory(pcategory);
            }
            List<Pcategory> pcategories = pcategoryService.findAllPcategorys();
            modelAndView.addObject("pcategorys", pcategories);
            modelAndView.addObject("successMessage", "Post Category has been added successfully");
            modelAndView.addObject("post", new Post());
            modelAndView.addObject("category", new Pcategory());
            modelAndView.setViewName("admin-add-blog");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/blogs/{blog_id}/edit", method = RequestMethod.GET)
    public ModelAndView blogEditPage(@PathVariable int blog_id, Model model){
        Post post = this.postService.getPostById(blog_id);
        ModelAndView modelAndView = new ModelAndView();
        List<Pcategory> pcategories = pcategoryService.findAllPcategorys();
        modelAndView.addObject("pcategorys", pcategories);
        modelAndView.addObject("post", post);
        modelAndView.addObject("category", new Pcategory());
        modelAndView.setViewName("admin-add-blog");
        return modelAndView;
    }

    @RequestMapping(value = "/blogs/{blog_id}/delete", method = RequestMethod.GET)
    public String blogDelete(@PathVariable int blog_id, Model model){
        this.postService.deletePostById(blog_id);
        return "redirect:/admin/blogs";
    }


    // Tracks Handlers goes here

    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public ModelAndView trackPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Track> tracks = this.trackService.findAllTracks();
        modelAndView.addObject("tracks", tracks);
        modelAndView.setViewName("admin-track");
        return (modelAndView);
    }


    @RequestMapping(value = "/tracks/add", method = RequestMethod.GET)
    public ModelAndView trackAddPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Track track = new Track();
        List<Course> courses = courseService.findAllCourses();
        modelAndView.addObject("all_courses", courses);
        modelAndView.addObject("track", track);
        modelAndView.setViewName("admin-add-track");
        return modelAndView;
    }


    @RequestMapping(value = "/tracks", method = RequestMethod.POST)
    public ModelAndView createNewTrack(@Valid Track track, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Course> courses = courseService.findAllCourses();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError("courses");
            if(fieldError != null){
                String values = fieldError.getRejectedValue().toString();
                String[] rejectedValues = values.split(",");
                Set<Course> rejectedList = new HashSet<>();
                for (String rejectedValue:rejectedValues){
                    rejectedList.add(courseService.getCourseById(Integer.parseInt(rejectedValue)));
                }
                track.setCourses(rejectedList);
                if(track.getId() == 0) {
                    trackService.addTrack(track);
                }
                else {
                    trackService.updateTrack(track);
                }
                modelAndView.addObject("successMessage", "Track has been added successfully");
                modelAndView.addObject("track", new Track());
                modelAndView.addObject("all_courses", courses);
                modelAndView.setViewName("admin-add-track");
            }
            else{
                modelAndView.setViewName("admin-add-track");
                modelAndView.addObject("all_courses", courses);
            }
        } else {
            if(track.getId() == 0) {
                trackService.addTrack(track);
            }
            else {
                trackService.updateTrack(track);
            }
            modelAndView.addObject("successMessage", "Track has been added successfully");
            modelAndView.addObject("track", new Track());
            modelAndView.addObject("all_courses", courses);
            modelAndView.setViewName("admin-add-track");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/tracks/{track_id}/edit", method = RequestMethod.GET)
    public ModelAndView trackEditPage(@PathVariable int track_id, Model model){
        Track track = this.trackService.getTrackById(track_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("track", track);
        modelAndView.setViewName("admin-add-track");
        return modelAndView;
    }

    @RequestMapping(value = "/tracks/{track_id}/delete", method = RequestMethod.GET)
    public String trackDelete(@PathVariable int track_id, Model model){
        this.trackService.deleteTrackById(track_id);
        return "redirect:/admin/tracks";
    }
}
