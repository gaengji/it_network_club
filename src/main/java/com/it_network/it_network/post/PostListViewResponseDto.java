package com.it_network.it_network.post;


import com.it_network.it_network.comment.CommentResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostListViewResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String author;

    private List<CommentResponseDto> comments;

    public PostListViewResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContents();
        this.createAt = post.getReg_date();
//        this.author = post.getAuthor();
        this.comments = post.getComments().stream().map(CommentResponseDto::new).toList();
    }

}
