package com.example.firstproject.service;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service // 서비스 역하을 하는 싱글톤을 스프링에 추가
public class TestService {

    public static final String HELLO = "hello";
    private final HikariDataSource dataSource;

    public TestService(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String profile() {

        return "profile";
    }

    public String shopping() {

        return "shopping";
    }


    public String hello() {
        return HELLO;
    }
}
