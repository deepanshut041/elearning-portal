package com.example.sawdhyay.controller;


import com.example.sawdhyay.models.Post;
import com.example.sawdhyay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private PostService postService;

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
