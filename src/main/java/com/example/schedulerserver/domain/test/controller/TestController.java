package com.example.schedulerserver.domain.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j(topic = "TestController")
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("")
    public String test() {
        return "test";
    }
}
