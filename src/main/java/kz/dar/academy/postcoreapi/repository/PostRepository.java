package kz.dar.academy.postcoreapi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findPostEntitiesBy();

    PostEntity findPostEntityByPostId(String postId);

    @Transactional
    void deletePostEntityByPostId(String postId);
}
