package com.liwy.server.controllers;

import com.google.gson.JsonObject;
import com.liwy.server.entity.AppData;
import com.liwy.server.entity.User;
import com.liwy.server.service.iservice.AppDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/7/9.
 */
@RequestMapping(value = "/appdata")
@Controller
public class AppDataController {

    @Autowired
    private AppDataService appDataService;

    @RequestMapping("/list")
    public Object getAppDataList(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        List<AppData> list = appDataService.getAppDatas(user.getId());
        ModelAndView mav = new ModelAndView("apptest/appdata");
        mav.addObject("menu","test");
        mav.addObject("appDatas",list);
        return mav;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpSession session,AppData appData){
        User user = (User) session.getAttribute("currentUser");
        appData.setUserId(user.getId());
        appData.setCreateTime(new Date());
        appDataService.insert(appData);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("state",0);
        return jsonObject.toString();
    }
}
