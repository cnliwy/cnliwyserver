package com.liwy.server.controllers;

import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by liwy on 2017/7/5.
 */
@Controller
public class LoginController {
    @RequestMapping("/toLogin")
    public Object toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public Object login(HttpSession session,String username, String password){
        System.out.println("收到了"+ username +"的登录请求");
        if ("liwy".equals(username)&&"123456".equals(password)){
            session.setAttribute("user","liwy");
            return "main";
        }
        return "login";
    }

    @RequestMapping("/main")
    public Object main(HttpSession session){
        System.out.println("当前用户是"+ session.getAttribute("user").toString());
        return "main";
    }
}
