package com.jerry.hello_oauth2.home;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HelloHomeControllerV2 {
    @GetMapping("/")
    public String home() {
        var oAuth2User = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(oAuth2User.getAttributes().get("email"));
        return "hello-oauth2";
    }
}
