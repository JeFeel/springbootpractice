package com.example.springbootpractice.blog.service;


import com.example.springbootpractice.blog.domain.dto.ArticleRequestDTO;
import com.example.springbootpractice.blog.domain.entity.Article;
import com.example.springbootpractice.blog.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 게시글 추가
    public Article save(ArticleRequestDTO requestDTO){
        return blogRepository.save(requestDTO.toEntity());
    }
}
