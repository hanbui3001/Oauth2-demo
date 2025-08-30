package com.Oauth2_demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    @GetMapping("/profile")
    public Map<Object, Object> profile(OAuth2AuthenticationToken token) {
        Map<Object, Object> map = new HashMap<>();
        map.put("name", token.getPrincipal().getAttribute("name"));
        map.put("email", token.getPrincipal().getAttribute("email"));
        map.put("photo", token.getPrincipal().getAttribute("picture"));
        return map;
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
