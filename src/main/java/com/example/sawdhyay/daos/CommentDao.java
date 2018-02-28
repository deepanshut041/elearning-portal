package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Comment;

import java.util.List;

public interface CommentDao {

    void saveComment(Comment comment);
    Comment getComment(int id);
    List<Comment> listComments();
    void updateComment(Comment comment);
    void deleteComment(int id);

}
