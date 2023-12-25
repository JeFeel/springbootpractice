package com.example.springbootpractice.blog.controller;


import com.example.springbootpractice.blog.domain.dto.ArticleRequestDTO;
import com.example.springbootpractice.blog.domain.entity.Article;
import com.example.springbootpractice.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogService blogService;

    // 게시글 추가
    @PostMapping("/api/articles")
    public ResponseEntity<Article> saveArticle(
            @RequestBody ArticleRequestDTO requestDTO
            ){
        return ResponseEntity.status(HttpStatus.valueOf(201)) // CREATED
                .body(blogService.save(requestDTO));
    }

}
