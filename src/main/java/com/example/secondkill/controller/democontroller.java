package com.example.secondkill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 */
@Controller
@RequestMapping("/demo")
public class democontroller {
    /**
     * 测试界面跳转
     */
    @RequestMapping("/hello")

    public String hello(Model model){
        model.addAttribute("name","qyb");
        return "hello";
    }

}
