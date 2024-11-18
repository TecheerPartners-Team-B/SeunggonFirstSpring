package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity // jpa에서 제공하는 어노테이션. @Entity가 붙은 클래스를 기반으로 DB 테이블 생성
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id; // long이 아니라 Long
    @Column
    private String title;
    @Column
    private String content;


    // @AllArgsConstructor를 추가하면서 삭제
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

    // @ToString을 추가하면서 삭제
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
