package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Comment;

import java.util.List;

public interface CommentDao {

    void saveComment(Comment comment);
    Comment getComment(int id);
    List<Comment> listComments();
    void updateComment(Comment comment);
    void deleteComment(int id);

}
