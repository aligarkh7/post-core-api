package kz.dar.academy.postcoreapi.service.deprecated;

import kz.dar.academy.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceOldImpl implements PostServiceOld {
    private static final HashMap<String, PostModel> postsMap = new HashMap<>();

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postsMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postsMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postsMap.get(postId);
    }

    @Override
    public boolean updatePostById(String postId, PostModel postModel) {
        if (!postsMap.containsKey(postId)) {
            return false;
        }

        postModel.setPostId(postId);
        postsMap.put(postId, postModel);
        return true;
    }

    @Override
    public boolean deletePostById(String postId) {
        if (!postsMap.containsKey(postId)) {
            return false;
        }

        postsMap.remove(postId);
        return true;
    }
}
