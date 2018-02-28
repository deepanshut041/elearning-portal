package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Post;

import java.util.List;

public interface PostDao {
    void savePost(Post post);
    Post getPost(int id);
    List<Post> listPosts();
    void updatePost(Post post);
    void deletePost(int id);
}
