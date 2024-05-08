package com.example.schedulerserver.domain.test.controller;

import com.example.schedulerserver.global.common.entity.ResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j(topic = "TestController")
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("")
    public ResponseBody<String> test() {
        return ResponseBody.of(HttpStatus.OK.value(), "Success", "test");
    }
}
