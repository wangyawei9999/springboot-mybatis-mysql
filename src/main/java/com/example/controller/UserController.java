package com.example.controller;

import com.example.domain.Admin;
import com.example.mapper.AdminMapper;
import com.example.mapper.UserMapper;
import com.example.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Api(tags = "Swagger功能测试接口")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有的数据
     * @return
     */
    @GetMapping(value = "/")
    @ResponseBody
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    public ModelAndView selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("users", users);
        modelAndView.addObject("account", "未登录");
        return modelAndView;
    }

    @GetMapping(value = "/addUser")
    @ApiOperation(value = "跳转到添加用户页面", notes = "跳转到添加用户页面")
    public String addUser() {
        return "addUser.html";
    }

    @PostMapping(value = "/addUserButton")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public String addUserButton(@RequestParam("userId") int id,
                                @RequestParam("userName") String name,
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

    @GetMapping(value = "/deleteUser")
    @ApiOperation(value = "跳转到删除用户页面", notes = "跳转到删除用户页面")
    public String deleteUser() {
        return "deleteUser.html";
    }

    @PostMapping(value = "/deleteUserButton")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public String deleteUserButton(@RequestParam(value = "deleteInputId") int id) {
        userMapper.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    @ApiOperation(value = "跳转到更改用户页面", notes = "跳转到更改用户页面")
    public String updateUser() {
        return "updateUser.html";
    }

    @PostMapping(value = "/updateUserButton")
    @ApiOperation(value = "更改用户", notes = "更改用户")
    public String updateUserButton(@RequestParam("userId") int id,
                                   @RequestParam("userName") String name,
                                   @RequestParam("userAge") int age,
                                   @RequestParam(value = "boyImg", required = false) boolean boyImg,
                                   @RequestParam(value = "girlImg", required = false) boolean girlImg) {
        if (boyImg) {
            String avatar = "../static/image/boy.png";
            userMapper.updateUserById(id, name, age, avatar);
        } else if (girlImg) {
            String avatar = "../static/image/girl.png";
            userMapper.updateUserById(id, name, age, avatar);
        } else {
            String avatar = "../static/image/sad.png";
            userMapper.updateUserById(id, name, age, avatar);
        }
        return "redirect:/";
    }

}
