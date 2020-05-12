package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveComment(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(comment);
        logger.info("Comment saved successfully, Comment Details=" + comment);
    }

    @Override
    public Comment getComment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Comment comment = (Comment) session.load(Comment.class, new Integer(id));
        logger.info("Comment loaded successfully, Comment details=" + comment);
        return comment;
    }

    @Override
    public List<Comment> listComments() {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> commentList = session.createQuery("from Comment").list();
        for(Comment comment : commentList){
            logger.info("Comment List::" + comment);
        }
        return commentList;
    }

    @Override
    public void updateComment(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(comment);
        logger.info("Comment updated successfully, Comment Details="+comment);
    }

    @Override
    public void deleteComment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Comment comment = (Comment) session.load(Comment.class, new Integer(id));
        if(null != comment){
            session.delete(comment);
        }
        logger.info("Comment deleted successfully, comment details=" + comment);
    }
}
