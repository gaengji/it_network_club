package com.it_network.it_network.comment;


import com.it_network.it_network.post.Post;
import com.it_network.it_network.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddCommentRequest {

    private Long id;
    private String content;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();
    private User user;
    private Post post;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .createdDate(createdDate)
                .updatedDate(updatedDate)
                .post(post)
                .user(user)
                .build();

    }
}
