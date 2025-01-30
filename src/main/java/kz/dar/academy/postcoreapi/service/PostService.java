package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    boolean updatePostById(String postId, PostModel postModel);
    boolean deletePostById(String postId);
}
