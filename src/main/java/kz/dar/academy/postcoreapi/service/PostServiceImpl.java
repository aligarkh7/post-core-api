package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.model.PostRequest;
import kz.dar.academy.postcoreapi.model.PostResponse;
import kz.dar.academy.postcoreapi.repository.PostEntity;
import kz.dar.academy.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());

        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findPostEntitiesBy().stream().map(postEntity -> modelMapper.map(postEntity, PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {
        PostEntity postEntity = postRepository.findPostEntityByPostId(postId);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse updatePostById(String postId, PostRequest postRequest) {
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);

        PostEntity dbPostEntity = postRepository.findPostEntityByPostId(postRequest.getPostId());

        postEntity.setId(dbPostEntity.getId());

        postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostEntityByPostId(postId);
    }
}
