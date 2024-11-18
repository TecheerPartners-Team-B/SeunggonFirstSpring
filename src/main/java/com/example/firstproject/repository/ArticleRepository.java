package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    // 기본 동작을 정의할 필요없이 CrudRepository에서 상속받아 사용할 수 있다.

    @Override
    ArrayList<Article> findAll();
}
