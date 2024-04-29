package org.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
    @GetMapping("/testMethod")
    public String testMethod() {
        return "This is a test method";
    }
}
