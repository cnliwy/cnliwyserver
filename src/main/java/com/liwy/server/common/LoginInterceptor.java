package com.liwy.server.common;

import com.liwy.server.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2017/7/7.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("login")>=0 || url.indexOf("toLogin")>=0 || url.indexOf("toRegister")>=0|| url.indexOf("register")>=0|| url.indexOf("test")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");

        if(user != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("toLogin").forward(request, response);

        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (null == modelAndView) {
            return;
        }
        //获取Session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        //网站basePath
        modelAndView.addObject("basePath", basePath);
        if (user != null) modelAndView.addObject("username",user.getUsername());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
