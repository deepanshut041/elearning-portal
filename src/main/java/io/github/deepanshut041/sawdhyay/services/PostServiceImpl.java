package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.PostDao;
import io.github.deepanshut041.sawdhyay.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    @Transactional
    public void addPost(Post post) {
        this.postDao.savePost(post);
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        this.postDao.updatePost(post);
    }

    @Override
    @Transactional
    public void deletePostById(int id) {
        this.postDao.deletePost(id);
    }

    @Override
    @Transactional
    public List<Post> findAllPosts() {
        return this.postDao.listPosts();
    }

    @Override
    @Transactional
    public Post getPostById(int id) {
        return this.postDao.getPost(id);
    }
}
