package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    // 웹 브라우저에서 localhost:8080/hi로 접속하면 greetings.mustache 파일을 찾아 반환하라
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        // model 객체가 "승곤"값을 "username"에 연결해 웹 브라우저로 보낸다.
        model.addAttribute("username", "승곤");
        return "greetings"; // greetings.mustache 반환
    }
    // 웹 브라우저에서 localhost:8080/bye로 접속하면 goodbye.mustache 파일을 찾아 반환하라
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
