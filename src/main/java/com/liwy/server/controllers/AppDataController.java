package com.liwy.server.controllers;

import com.google.gson.JsonObject;
import com.liwy.server.entity.AppData;
import com.liwy.server.entity.User;
import com.liwy.server.service.iservice.AppDataService;
import com.liwy.server.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<AppData> list = appDataService.getAppDatas(user.getId(),null);
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

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(HttpSession session,String id){
        appDataService.delete(id);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("state",0);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Object edit(HttpSession session,AppData appData){
        JsonObject jsonObject = new JsonObject();
        if (StringUtils.isNull(appData.getJsonKey()) || StringUtils.isNull(appData.getJsonData())){
            jsonObject.addProperty("state",-1);
            jsonObject.addProperty("result","key或者jsonData不能为空哦");
        }else{
            appDataService.update(appData);
            jsonObject.addProperty("state",0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getTestData", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object getData(@RequestParam String session,@RequestParam String jsonKey){
        System.out.println("请求的session=" + session + ",jsonKey:" + jsonKey);
        List<AppData> datas =  appDataService.getAppDatas(session,jsonKey);
        if (datas != null && datas.size() > 0){
            System.out.println("查到数据:" + datas.get(0).toString());
            return datas.get(0).getJsonData();
        }
        return "";
    }
}
