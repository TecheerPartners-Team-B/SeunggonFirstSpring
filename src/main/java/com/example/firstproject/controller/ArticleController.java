package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller // 컨트롤러 선언
public class ArticleController {
    // 의존성 주입(스프링부트 제공 어노테이션)
    @Autowired // new로 객체를 만들지 않고도 스프링 부트가 알아서 객체를 미리 생성하고 가져다가 연결해준다. 이런식으로 컨트롤러의 필드에 붙이면 끝
    private ArticleRepository articleRepository; // post 메서드 만들면서 ArticleRepository 객체 선언

    // 두 번째로 만든 메서드, Get
    @GetMapping("/articles/new") // URL 요청 접수
    public String newArticleForm() { // 메서드 선언 및 반환값 작성
        return "articles/new";
    }

    // 첫번째로 만든 메서드, Post
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
//        System.out.println(form.toString());
        // 1. DTO를 Entity(엔티티)로 변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        log.info(saved.toString());
//        System.out.println(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) { // URL 요청으로 들어온 전달 값을 컨트롤러의 매개변수로 가져옴
        log.info("id = "+id);

        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);// id값으로 데이터를 찾을 때 해당 id값이 없으면 null
        // 2. 모델에 데이터 등록하기
//        model.addAttribute(String name, Object value)
        model.addAttribute("article",articleEntity);

        // 3. 뷰 페이지 반환하기

        return "articles/show";
    }

    // 데이터 목록 조회
    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList",articleEntityList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }


}
