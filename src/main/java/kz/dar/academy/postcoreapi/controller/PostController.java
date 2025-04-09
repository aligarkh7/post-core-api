package kz.dar.academy.postcoreapi.controller;

import jakarta.validation.Valid;
import kz.dar.academy.postcoreapi.model.PostModel;
import kz.dar.academy.postcoreapi.model.PostRequest;
import kz.dar.academy.postcoreapi.model.PostResponse;
import kz.dar.academy.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    Environment environment;

    @Autowired
    private PostService postService;

    @GetMapping("check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("post-core-api is working at " + environment.getProperty("local.server.port"));
    }

    @PostMapping
    public PostResponse createPost(@Valid @RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    @GetMapping("all")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping
    public PostResponse getPostById(@RequestParam String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping
    public PostResponse updatePostById(@RequestParam String postId,
                                       @Valid @RequestBody PostRequest postRequest) {
        postRequest.setPostId(postId);
        return postService.updatePostById(postId, postRequest);
    }

    @DeleteMapping
    public void deletePostById(@RequestParam String postId) {
        postService.deletePostById(postId);
    }
}
