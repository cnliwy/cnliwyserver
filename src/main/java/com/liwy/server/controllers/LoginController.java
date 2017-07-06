package com.liwy.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liwy on 2017/7/5.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public Object login(){
        System.out.println("收到了登录请求");
        return "login";
    }

    @RequestMapping("/test")
    public Object test(@RequestParam String account,@RequestParam String password){
        System.out.println("account=" + account + ",password=" + password);
        return "index";
    }
}
