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
    @RequestMapping(value = "/insert/{id}/{name}/{age}/{avatar}")
    public String insertUser(@PathVariable int id, @PathVariable String name, @PathVariable int age, @PathVariable String avatar) {
        userMapper.insertUser(id, name, age, avatar);
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
    public String addUserButton(@RequestParam("userId") int id, @RequestParam("userName") String name,
                                @RequestParam("userAge") int age, String avatar,
                                @RequestParam(value = "image001", required = false) boolean image001) {
        if (image001) {
            avatar = "../static/image/sad.png";
            userMapper.insertUser(id, name, age, avatar);
        } else {
            avatar = "../static/image/hana.jpeg";
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
    public String updateUserButton(@RequestParam("userId") int id, @RequestParam("userName") String name, @RequestParam("userAge") int age) {
        userMapper.updateUserById(id, name, age);
        return "redirect:/";
    }

}
