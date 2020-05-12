package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.CommentDao;
import io.github.deepanshut041.sawdhyay.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        this.commentDao.saveComment(comment);
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        this.commentDao.updateComment(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(int id) {
        this.commentDao.deleteComment(id);
    }

    @Override
    @Transactional
    public List<Comment> findAllComments() {
        return this.commentDao.listComments();
    }

    @Override
    @Transactional
    public Comment getCommentById(int id) {
        return this.commentDao.getComment(id);
    }
}
