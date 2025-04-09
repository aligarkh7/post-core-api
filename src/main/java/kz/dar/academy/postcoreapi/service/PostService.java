package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.model.PostRequest;
import kz.dar.academy.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse createPost(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postId);

    PostResponse updatePostById(String postId, PostRequest postRequest);

    void deletePostById(String postId);
}
