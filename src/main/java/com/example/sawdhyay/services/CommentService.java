package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(int id);

    List<Comment> findAllComments();

    Comment getCommentById(int id);
    
}
