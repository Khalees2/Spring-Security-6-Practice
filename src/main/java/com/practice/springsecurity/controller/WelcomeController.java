package com.practice.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
         return "Welcome to Spring Application with security";
    }

    @GetMapping("/about")
    public String getAboutMessage() { return "About Spring Security Basics"; }

    @GetMapping("/contact")
    public String getContactMessage() { return "Contact: 0894428445"; }
}
