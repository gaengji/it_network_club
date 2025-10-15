package com.it_network.it_network.comment;

import com.it_network.it_network.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentByPostOrderById(Post post);
    Optional<Comment> findByPostIdAndId(Long postId, Long id);
}
