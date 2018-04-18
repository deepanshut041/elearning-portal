package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.*;
import com.example.sawdhyay.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    CourseService courseService;

    @Autowired
    StepService stepService;

    @Autowired
    CourseProgressService courseProgressService;

    @RequestMapping(value = {"/", "", "/courses"}, method = RequestMethod.GET)
    public ModelAndView classroomPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = userService.findUserByEmail(username);
        Student student = studentService.getStudentByUserId(user.getId());

        List<Enrollment> enrollments = enrollmentService.findEnrollmentsByStudent(student.getId());
        modelAndView.addObject("enrollments", enrollments);
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public ModelAndView classroomSettingPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-settings");
        return modelAndView;
    }
    @RequestMapping(value = "/enroll/{id}", method = RequestMethod.POST)
    public String createNewEnrollment(@Valid Enrollment enrollment,@PathVariable int id, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Enrollment enrollment1 = new Enrollment();
        Course course = new Course();
        course.setId(id);
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = userService.findUserByEmail(username);
        Student student = studentService.getStudentByUserId(user.getId());
        enrollment1.setStudent(student);
        enrollment1.setCourse(course);
        Enrollment check_enrollment = enrollmentService.getEnrollmentsByStudentAndCourse(student.getId(), course.getId());
        if (check_enrollment == null) {
            enrollmentService.addEnrollment(enrollment1);
        }
        return "redirect:/classroom";
    }

    @RequestMapping(value = "{enroll_id}/progress/{id}", method = RequestMethod.POST)
    public String createNewProgress(@PathVariable int enroll_id, @PathVariable int id, BindingResult bindingResult) {
        CourseProgress courseProgress = new CourseProgress();
        Step step = new Step();
        step.setId(id);
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enroll_id);
        courseProgress.setStep(step);
        courseProgress.setEnrollment(enrollment);
        CourseProgress courseProgress1 = courseProgressService.getCourseProgressByStepAndCourseProgress(enroll_id, id);
        if (courseProgress1 == null) {
            courseProgressService.addCourseProgress(courseProgress);
        }
        return "redirect:/classroom";
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ModelAndView classroomCoursePage(@PathVariable int id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        modelAndView.addObject("enrollment", enrollment);
        modelAndView.setViewName("classroom-course");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{id}/step/{step_id}", method = RequestMethod.GET)
    public ModelAndView classroomDetailCoursePage(@PathVariable int id,@PathVariable int step_id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        Step step = stepService.getStepById(step_id);
        modelAndView.addObject("enrollment", enrollment);
        modelAndView.addObject("current", step);
        modelAndView.setViewName("classroom-course");
        return modelAndView;
    }

}

