package com.jerry.hello_oauth2.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HelloHomeControllerV1 {
    @GetMapping("/")
    public String home() {
        return "hello-oauth2";
    }
}
