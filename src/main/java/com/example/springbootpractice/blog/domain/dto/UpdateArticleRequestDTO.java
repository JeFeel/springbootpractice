package com.example.springbootpractice.blog.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleRequestDTO {

    // 게시글 수정을 요청하는 DTO
    private String title;
    private String content;
}
