package com.springboot.demo.controller;

import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.model.User;
import com.springboot.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/getuser")
    public List<User> getUser(){
        UserExample userExample=new UserExample();
        List<User> users=userMapper.selectByExample(userExample);
        return users;
    }
}
