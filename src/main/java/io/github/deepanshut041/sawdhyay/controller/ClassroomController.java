package io.github.deepanshut041.sawdhyay.controller;

import io.github.deepanshut041.sawdhyay.models.*;
import io.github.deepanshut041.sawdhyay.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    
    private final StudentService studentService;

    private final UserService userService;

    private final EnrollmentService enrollmentService;

    private final CourseService courseService;

    private final StepService stepService;

    private final CourseProgressService courseProgressService;

    public ClassroomController(StudentService studentService, UserService userService, EnrollmentService enrollmentService, CourseService courseService, StepService stepService, CourseProgressService courseProgressService) {
        this.studentService = studentService;
        this.userService = userService;
        this.enrollmentService = enrollmentService;
        this.courseService = courseService;
        this.stepService = stepService;
        this.courseProgressService = courseProgressService;
    }


    @RequestMapping(value = {"/", "", "/courses"}, method = RequestMethod.GET)
    public ModelAndView classroomPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroom-home");
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = userService.findUserByEmail(username);
        Student student = studentService.getStudentByUserId(user.getId());
        if (student == null){
            return new ModelAndView(new RedirectView("/classroom/settings"));
        }
        List<Enrollment> enrollments = enrollmentService.findEnrollmentsByStudent(student.getId());
        modelAndView.addObject("enrollments", enrollments);
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView classroomSettingPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = userService.findUserByEmail(username);
        Student student = studentService.getStudentByUserId(user.getId());
        if (student == null){
            student = new Student();
        }
        modelAndView.addObject("student", student);
        modelAndView.setViewName("classroom-settings");
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public ModelAndView classroomSettingPost(@Valid Student student, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            student = studentService.getStudentByUserId(user.getId());
            if (student == null){
                student = new Student();
            }
            modelAndView.addObject("student", student);
            modelAndView.setViewName("classroom-settings");
        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            User user = userService.findUserByEmail(username);
            User user1 = new User();
            user1.setId(user.getId());
            student.setUser(user1);
            if(student.getId() == 0) {
                studentService.addStudent(student);
            }
            else {
                studentService.updateStudent(student);
            }
            return new ModelAndView(new RedirectView("/classroom"));
        }
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

    @RequestMapping(value = "{enroll_id}/progress/{id}", method = RequestMethod.GET)
    public String createNewProgress(@PathVariable int enroll_id, @PathVariable int id, Model model) {
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
        return "redirect:/classroom/courses/" + enroll_id + "/step/" + id ;
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
    public ModelAndView classroomDetailCoursePage(@PathVariable int id,
                                                  @PathVariable int step_id,
                                                  @RequestParam(value="isdone", required=false) String idone,
                                                  Model model){
        ModelAndView modelAndView = new ModelAndView();
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        Step step = stepService.getStepById(step_id);
        CourseProgress courseProgress = courseProgressService.getCourseProgressByStepAndCourseProgress(id, step_id);
        modelAndView.addObject("enrollment", enrollment);
        modelAndView.addObject("current", step);
        modelAndView.addObject("cprogress", courseProgress);
        modelAndView.setViewName("classroom-course");
        return modelAndView;
    }

}

