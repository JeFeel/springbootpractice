package com.example.springbootpractice.blog.domain.repository;


import com.example.springbootpractice.blog.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Article, Long> {

}
