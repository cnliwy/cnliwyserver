package com.liwy.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 2017/7/9.
 */
@RequestMapping(value = "/test")
@Controller
public class AppTestController {

    @RequestMapping("/test")
    public Object test(){
        ModelAndView mav = new ModelAndView("apptest/testIndex");
        mav.addObject("menu","test");;
        return mav;
    }
}
