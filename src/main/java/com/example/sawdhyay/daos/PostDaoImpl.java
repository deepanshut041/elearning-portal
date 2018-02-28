package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public class PostDaoImpl implements PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void savePost(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(post);
        logger.info("Post saved successfully, Post Details=" + post);
    }

    @Override
    public Post getPost(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Post post = (Post) session.load(Post.class, new Integer(id));
        logger.info("Post loaded successfully, Post details=" + post);
        return post;
    }

    @Override
    public List<Post> listPosts() {
        Session session = sessionFactory.getCurrentSession();
        List<Post> postList = session.createQuery("from Post").list();
        for(Post post : postList){
            logger.info("Post List::" + post);
        }
        return postList;
    }

    @Override
    public void updatePost(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(post);
        logger.info("Post updated successfully, Post Details="+post);
    }

    @Override
    public void deletePost(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Post post = (Post) session.load(Post.class, new Integer(id));
        if(null != post){
            session.delete(post);
        }
        logger.info("Post deleted successfully, post details=" + post);
    }
}
