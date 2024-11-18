package com.example.firstproject.controller;

import com.example.firstproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // 싱글톤
@RequestMapping("/test-api") // 서블릿 매핑 정보
public class TestConroller {

    @Autowired
    public TestService testService;
}
