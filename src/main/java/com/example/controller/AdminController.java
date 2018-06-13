package com.example.controller;

import com.example.domain.Admin;
import com.example.domain.User;
import com.example.mapper.AdminMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/loginButton")
    public ModelAndView loginButton(@RequestParam("account") String account, @RequestParam("password") String password) {
        Admin admin = adminMapper.selectAdminByAccount(account);
        List<User> users = userMapper.selectAllUser();
        if (admin.getPassword().equals(password)) {
            ModelAndView modelAndView = new ModelAndView("index.html");
            modelAndView.addObject("account", admin.getAccount());
            modelAndView.addObject("users", users);
            return modelAndView;
        }
        return new ModelAndView("404.html");
    }

    @RequestMapping("/register")
    public String registerAdmin() {
        return "register.html";
    }

    @RequestMapping("/registerAdminButton")
    public String registerAdminButton(@RequestParam("accountRegister") String account,
                                      @RequestParam("passwordRegister") String password) {
        adminMapper.insertAdmin(account, password);
        return "redirect:/login";
    }

}
