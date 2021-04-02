package com.jpaproject.jpaproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home() {
        log.info("접속");
        return "/main/main";
    }

    @RequestMapping("/user")
    public String userHome() {
        log.info("로그인");
        return "/main/mainUser";
    }

    @RequestMapping("/admin")
    public String adminHome() {
        log.info("관리자 로그인");
        return "/main/mainAdmin";
    }
}
