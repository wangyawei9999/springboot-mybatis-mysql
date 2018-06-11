package com.example.springbootmybatismysql.controller;

import com.example.springbootmybatismysql.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/loginButton")
    public String loginButton(@RequestParam("account") String account, @RequestParam("password") String password) {
        if (adminMapper.selectAdminByAccount(account).getPassword().equals(password)) {
            return "redirect:/";
        }
        return "/404";
    }

    @RequestMapping("/register")
    public String registerAdmin() {
        return "/register";
    }

    @RequestMapping("/registerAdminButton")
    public String registerAdminButton(@RequestParam("accountRegister") String account, @RequestParam("passwordRegister") String password) {
        adminMapper.insertAdmin(account, password);
        return "redirect:/login";
    }

    @RequestMapping("/image")
    public String image() {
        return "404";
    }
}
