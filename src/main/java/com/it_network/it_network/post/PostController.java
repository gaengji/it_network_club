package com.it_network.it_network.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시물 작성 postman post
    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostFormDto form) {
        Post savedPost = postService.createPost(form);
        return ResponseEntity.ok("게시물이 작성되었습니다. id=" + savedPost.getId());
    }

    // 게시글 수정 put
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Integer id,
                                             @RequestBody PostFormDto form) {
        postService.updatePost(id, form);
        return ResponseEntity.ok("게시물이 수정되었습니다. id=" + id);
    }

    // 게시물 삭제 delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok("게시물이 삭제되었습니다. id=" + id);
    }


}
