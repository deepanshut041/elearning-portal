package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Post;

import java.util.List;

public interface PostService {
    void addPost(Post post);

    void updatePost(Post post);

    void deletePostById(int id);

    List<Post> findAllPosts();

    Post getPostById(int id);

//    List<Post> findPostsByCategory(int category);
//
//    List<Post> findPostsByMentor(int mentor_id);

}
