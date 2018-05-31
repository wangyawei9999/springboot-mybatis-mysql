package com.example.springbootmybatismysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/loginButton")
    public String loginButton(@RequestParam("account") String account, @RequestParam("password") String password) {
        if (account.equals("admin") && password.equals("123")) {
            return "redirect:/";
        }
        return "/404";
    }
}
