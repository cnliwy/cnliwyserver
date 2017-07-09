package com.liwy.server.controllers;

import com.liwy.server.service.UserService;
import com.liwy.server.entity.User;
import com.liwy.server.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by liwy on 2017/7/5.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public Object toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public Object toRegister(){
        System.out.println("千万注册");
        return "register";
    }

    @RequestMapping("/register")
    public Object register(HttpSession session, User user){
        String result = "";
        String destination = "";
        System.out.println("注册用户" + user.toString());
        if (user != null && !StringUtils.isNull(user.getUsername()) && !StringUtils.isNull(user.getPassword()) && !StringUtils.isNull(user.getName())){
            List<User> users = userService.findUser("from User where username='" + user.getUsername() + "'");
            if (users != null && users.size() > 0){
                result = "用户名已存在";
                destination = "register";
            }else{
                userService.saveUser(user);
                result = "注册成功,请登录";
                destination = "login";
        }
        }else{
            result = "账号、密码和真实姓名不能为空";
            destination = "login";
        }
        ModelAndView mav = new ModelAndView(destination);
        mav.addObject("result", result);
        return mav;
    }

    @RequestMapping("/login")
    public Object login(HttpSession session, String username, String password){
        System.out.println("收到了"+ username +"的登录请求");
        String result = "";
        String des = "";
        ModelAndView mav = new ModelAndView();
        User user = userService.findUser(username,password);
        if (user != null){
            System.out.println(user.toString());
            session.setAttribute("currentUser",user);
            mav.addObject("menu","index");;
            des = "main";
        }else{
            result = "账号密码错误";
            des = "login";
        }
        mav.setViewName(des);
        mav.addObject("result", result);

        return mav;
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("currentUser");
        return "login";
    }

    @RequestMapping("/main")
    public Object main(HttpSession session){
        System.out.println("当前用户是"+ session.getAttribute("currentUser").toString());
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("menu","index");;
        return mav;
    }
}
