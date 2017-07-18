package com.liwy.server.controllers;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.notification.Notification;
import com.google.gson.JsonObject;
import com.liwy.server.dao.idao.PushDataDao;
import com.liwy.server.entity.PushData;
import com.liwy.server.entity.User;
import com.liwy.server.service.iservice.PushService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liwy on 2017/7/18.
 */
@RequestMapping(value = "/push")
@Controller
public class PushController {
    public static String MASTER_SECRET = "70e58f8bac2e0641c8841d80";
    public static String APP_KEY = "5bf4234604598342f195d35a";
    public Logger LOG = Logger.getLogger("push");

    @Autowired
    private PushService pushService;

    @RequestMapping("/pushManage")
    public Object pushPage(HttpSession httpSession){
        User user = (User)httpSession.getAttribute("currentUser");
        List<PushData> pushDataList = pushService.list(user.getId());
        ModelAndView mav = new ModelAndView("push/push");
        mav.addObject("menu","push");
        mav.addObject("identity","123");
        mav.addObject("pushDatas",pushDataList);
        return mav;
    }

    @RequestMapping(value = "/pushAction",method = RequestMethod.POST)
    @ResponseBody
    public Object pushAction(HttpSession httpSession,PushData pushData){
        User user = (User)httpSession.getAttribute("currentUser");
        push(pushData.getNotifyTitle(),pushData.getNotifyContent());
        pushData.setPushTime(new Date());
        pushData.setSenderId(user.getId());
        pushData.setPushType("all");
        pushService.insert(pushData);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("state",0);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(HttpSession session,String id){
        pushService.delete(id);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("state",0);
        return jsonObject.toString();
    }



    public void push(String title,String content){
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert(title,content);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());

        }
    }

    public static PushPayload buildPushObject_all_all_alert(String title,String content) {
        return PushPayload.alertAll(content);
//        return PushPayload.newBuilder()
//                .setPlatform(Platform.android())
////                .setAudience(Audience.tag("tag1"))
//                .setNotification(Notification.android(content, title, null))
//                .build();
    }
}
