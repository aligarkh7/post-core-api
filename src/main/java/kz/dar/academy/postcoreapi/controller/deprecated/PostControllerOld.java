package kz.dar.academy.postcoreapi.controller.deprecated;

import jakarta.validation.Valid;
import kz.dar.academy.postcoreapi.model.PostModel;
import kz.dar.academy.postcoreapi.service.deprecated.PostServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deprecated/post")
public class PostControllerOld {

    @Autowired
    Environment environment;

    @Autowired
    private PostServiceOld postServiceOld;


    @GetMapping("check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("post-core-api is working at " + environment.getProperty("local.server.port"));
    }

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel) {
        postServiceOld.createPost(postModel);
        return ResponseEntity.ok("Post is created");
    }

    @GetMapping("all")
    public List<PostModel> getAllPosts() {
        return postServiceOld.getAllPosts();
    }

    @GetMapping("{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postServiceOld.getPostById(postId);
    }

    @PutMapping("{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId,
                                                 @Valid @RequestBody PostModel postModel) {
        return ResponseEntity.ok(postServiceOld.updatePostById(postId, postModel) ? "Post is modified" : "The post does not exist");
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        return ResponseEntity.ok(postServiceOld.deletePostById(postId) ? "Post is deleted" : "Post is deleted or does not exist");
    }
}
