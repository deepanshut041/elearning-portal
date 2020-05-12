package io.github.deepanshut041.sawdhyay.controller;


import io.github.deepanshut041.sawdhyay.models.Post;
import io.github.deepanshut041.sawdhyay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final PostService postService;

    @Autowired
    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView blogsPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Post> posts = postService.findAllPosts();
        modelAndView.addObject("posts", posts);
        modelAndView.setViewName("blogs");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView blogPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog");
        return modelAndView;
    }



}
