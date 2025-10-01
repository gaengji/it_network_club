package com.it_network.it_network.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 글 작성
    public Post createPost(PostFormDto form) {
        Post post = new Post();
        post.createPost(form.getMember_id(), form.getCategory_id(),
                form.getTitle(), form.getContents(), form.getReg_id());
        return postRepository.save(post);
    }

    // 글 수정
    public void updatePost(Integer id, PostFormDto form) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시물이 존재하지 않습니다. id=" + id));
        post.updatePost(form.getCategory_id(), form.getTitle(),
                form.getContents(), form.getUpd_id(), null);
        postRepository.save(post);
    }

    // 글 삭제
    public void deletePost(Integer id) {
        if (!postRepository.existsById(id)) {
            throw new IllegalArgumentException("삭제할 게시물이 존재하지 않습니다. id=" + id);
        }
        postRepository.deleteById(id);
    }
}
