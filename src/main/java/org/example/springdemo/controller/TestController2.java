package org.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {
    @GetMapping("/testPage")
    public String getTestPage() {
        return "test";
    }
}
