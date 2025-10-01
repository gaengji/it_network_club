package com.it_network.it_network.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFormDto {

    private String title;
    private String contents;
    private Integer member_id;
    private Integer category_id;
    private String reg_id;
    private String upd_id;
}
