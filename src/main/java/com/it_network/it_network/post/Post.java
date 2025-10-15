package com.it_network.it_network.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.it_network.it_network.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post_tbl")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; // 게시물 일련번호

    @Column(nullable = false)
    private Integer member_id; // 회원 일련번호

    @Column(nullable = false)
    private Integer category_id; // 카테고리 일련번호

    @Column(nullable = false, length = 1000)
    private String title; // 제목

    @Lob
    @Column(nullable = false)
    private String contents; // 내용

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer hit_cnt; // 조회수 기본값 0

    @Column(nullable = false, length = 15)
    private String reg_id; // 등록자

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime reg_date; // 등록일

    @Column(length = 15)
    private String upd_id; // 수정자

    @UpdateTimestamp
    @Column
    private LocalDateTime upd_date; // 수정일

    // 댓글 목록 (게시글 삭제 시 댓글도 함께 삭제)
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonManagedReference("post-comments")
    @OrderBy("id asc")
    private List<Comment> comments;

    // 작성
    public void createPost(Integer member_id, Integer category_id, String title,
                           String contents, String reg_id) {
        this.member_id = member_id;
        this.category_id = category_id;
        this.title = title;
        this.contents = contents;
        this.reg_id = reg_id;
        this.hit_cnt = 0;
    }

    // 수정
    public void updatePost(Integer category_id, String title,
                           String contents, String upd_id, LocalDateTime upd_date) {
        this.category_id = category_id;
        this.title = title;
        this.contents = contents;
        this.upd_id = upd_id;
        this.upd_date = upd_date;
    }
}
