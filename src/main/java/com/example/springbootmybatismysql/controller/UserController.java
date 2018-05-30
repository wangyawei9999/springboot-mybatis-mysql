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

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/select/{id}")
    @ResponseBody
    public ModelAndView selectUserById(@PathVariable int id) {
        User user = userMapper.selectUserById(id);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("users", user);
        return modelAndView;
    }

    /**
     * 插入数据
     * @param id
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/insert/{id}/{name}/{age}")
    public String insertUser(@PathVariable int id, @PathVariable String name, @PathVariable int age) {
        userMapper.insertUser(id, name, age);
        return "redirect:/";
    }


    /**
     * 根据id删除数据
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        userMapper.deleteUserById(id);
        return "redirect:/";
    }

    /**
     * 根据id更新数据
     * @param id
     * @param name
     * @param age
     */
    @RequestMapping(value = "/update/{id}/{name}/{age}")
    public String updateUserById(@PathVariable int id, @PathVariable String name, @PathVariable int age) {
        userMapper.updateUserById(id, name, age);
        return "redirect:/";
    }

    @RequestMapping(value = "/addUser")
    public String addUser() {
        return "/addUser";
    }

    @RequestMapping(value = "/addUserButton")
    public String addUserButton() {
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

}
