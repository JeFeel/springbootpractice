package com.example.springbootpractice.blog.service;


import com.example.springbootpractice.blog.domain.dto.ArticleRequestDTO;
import com.example.springbootpractice.blog.domain.dto.UpdateArticleRequestDTO;
import com.example.springbootpractice.blog.domain.entity.Article;
import com.example.springbootpractice.blog.domain.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 게시글 추가
    public Article save(ArticleRequestDTO requestDTO) {
        return blogRepository.save(requestDTO.toEntity());
    }

    // 게시글 목록 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 게시글 하나 조회
    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("article not found: " + id));
    }

    // 게시글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 게시글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequestDTO requestDTO) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("article not found: " + id));

        article.update(requestDTO.getTitle(), requestDTO.getContent());
        return article;
    }
}
