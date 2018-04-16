package com.example.sawdhyay.controller;

import com.example.sawdhyay.models.Enrollment;
import com.example.sawdhyay.models.Student;
import com.example.sawdhyay.models.User;
import com.example.sawdhyay.services.EnrollmentService;
import com.example.sawdhyay.services.StudentService;
import com.example.sawdhyay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = {"/", "", "/courses"}, method = RequestMethod.GET)
    public ModelAndView classroomPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public ModelAndView classroomSettingPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-settings");
        return modelAndView;
    }
    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public String createNewEnrollment(@Valid Enrollment enrollment, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {

        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            Student student = studentService.getStudentByUserId(user.getId());
            enrollment.setStudent(student);
            try {
                enrollmentService.addEnrollment(enrollment);
            }
            catch (DataIntegrityViolationException ex)
            {

            }

        }
        return "redirect:/classroom";
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ModelAndView classroomCoursePage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        return modelAndView;
    }

}

