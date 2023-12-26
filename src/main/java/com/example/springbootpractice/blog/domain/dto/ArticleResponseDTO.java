package com.example.springbootpractice.blog.domain.dto;


import com.example.springbootpractice.blog.domain.entity.Article;
import lombok.Getter;


@Getter
public class ArticleResponseDTO {

    private final String title;
    private final String content;

    public ArticleResponseDTO(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
