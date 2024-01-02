package com.example.springbootpractice.blog.domain.dto;


import com.example.springbootpractice.blog.domain.entity.Article;
import lombok.Getter;


@Getter
public class ArticleListViewResponse {
    // 뷰에게 데이터를 전달하기 위한 객체 생성

    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
