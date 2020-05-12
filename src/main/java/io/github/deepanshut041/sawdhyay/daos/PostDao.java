package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Post;

import java.util.List;

public interface PostDao {
    void savePost(Post post);
    Post getPost(int id);
    List<Post> listPosts();
    void updatePost(Post post);
    void deletePost(int id);
}
