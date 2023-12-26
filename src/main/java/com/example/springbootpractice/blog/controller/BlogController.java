package com.example.springbootpractice.blog.controller;


import com.example.springbootpractice.blog.domain.dto.ArticleRequestDTO;
import com.example.springbootpractice.blog.domain.dto.ArticleResponseDTO;
import com.example.springbootpractice.blog.domain.entity.Article;
import com.example.springbootpractice.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDTO>> findAllArticles(){
        List<ArticleResponseDTO> articles = blogService.findAll()
                .stream()
                .map(ArticleResponseDTO::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDTO> findArticle(
            @PathVariable long id
    ){
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponseDTO(article));
    }
}
