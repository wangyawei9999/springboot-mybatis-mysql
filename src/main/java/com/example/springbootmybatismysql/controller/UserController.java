package com.example.springbootmybatismysql.controller;

import com.example.springbootmybatismysql.domain.User;
import com.example.springbootmybatismysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有的数据
     * @return
     */
    @RequestMapping(value = "/")
    @ResponseBody
    public ModelAndView selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public String addUser() {
        return "/addUser";
    }

    @RequestMapping(value = "/addUserButton")
    public String addUserButton(@RequestParam("userId") int id, @RequestParam("userName") String name,
                                @RequestParam("userAge") int age,
                                @RequestParam(value = "boyImg", required = false) boolean boyImg,
                                @RequestParam(value = "girlImg", required = false) boolean girlImg) {
        if (boyImg) {
            String avatar = "../static/image/boy.png";
            userMapper.insertUser(id, name, age, avatar);
        } else if (girlImg) {
            String avatar = "../static/image/girl.png";
            userMapper.insertUser(id, name, age, avatar);
        } else {
            String avatar = "../static/image/sad.png";
            userMapper.insertUser(id, name, age, avatar);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser() {
        return "/deleteUser";
    }

    @RequestMapping(value = "/deleteUserButton")
    public String deleteUserButton(@RequestParam(value = "deleteInputId") int id) {
        userMapper.deleteUserById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser() {
        return "/updateUser";
    }

    @RequestMapping(value = "/updateUserButton")
    public String updateUserButton(@RequestParam("userId") int id, @RequestParam("userName") String name,
                                   @RequestParam("userAge") int age,
                                   @RequestParam(value = "boyImg", required = false) boolean boyImg,
                                   @RequestParam(value = "girlImg", required = false) boolean gitlImg) {
        if (boyImg) {
            String avatar = "../static/image/boy.png";
            userMapper.updateUserById(id, name, age, avatar);
        } else if (gitlImg) {
            String avatar = "../static/image/girl.png";
            userMapper.updateUserById(id, name, age, avatar);
        } else {
            String avatar = "../static/image/sad.png";
            userMapper.updateUserById(id, name, age, avatar);
        }
        return "redirect:/";
    }

}
