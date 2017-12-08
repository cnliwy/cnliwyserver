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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

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
        mav.addObject("identity",user.getId());
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
    public Object getData(@RequestParam(required = false) String identity,@RequestParam(required = false) String jsonKey){
        System.out.println("请求的identity=" + identity + ",jsonKey:" + jsonKey);
        List<AppData> datas =  appDataService.getAppDatas(identity,jsonKey);
        if (datas != null && datas.size() > 0){
            System.out.println("查到数据:" + datas.get(0).toString());
            return datas.get(0).getJsonData();
        }
        return "无数据";
    }
    private static String fileDirectory = "liwy";
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadFile(HttpServletRequest request,@RequestParam(required = false,value = "uploader")String uploader,@RequestParam(value="image2", required=false) MultipartFile head,@RequestParam(value="bgimg", required=false) MultipartFile code){
        System.out.println("开始接受图片");
//        String uploader = (String) request.getAttribute("uploader");
        System.out.println("上传者：" + uploader);

//        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
//        Map<String,MultipartFile> files = mRequest.getFileMap();
        //项目的绝对路径   request.getSession().getServletContext().getRealPath()这个是得到项目的绝对地址
        String ctxPath = request.getSession().getServletContext().getRealPath("/")
                + fileDirectory;
        System.out.println("项目路径="+ ctxPath);
        File file = new File(ctxPath);
        if (!file.exists()) {
            file.mkdir();
        }

        try {
            File writeFile = new File(ctxPath + head.getOriginalFilename());
            if (!file.exists())writeFile.createNewFile();
            head.transferTo(writeFile);
            return "上传成功：" + writeFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Map<String, Object> result = new HashMap<String, Object>();
//        Iterator<Map.Entry<String, MultipartFile>> it = files.entrySet().iterator();
//        //用hasNext() 判断是否有值，用next()方法把元素取出。
//        while(it.hasNext()){
//            Map.Entry<String, MultipartFile> entry = it.next();
//            MultipartFile mFile = entry.getValue();
//            if(mFile.getSize() != 0 && !"".equals(mFile.getName())){
//                try {
//                    File writeFile = new File(ctxPath+mFile.getOriginalFilename());
//                    if (!file.exists())writeFile.createNewFile();
//                    mFile.transferTo(writeFile);
////                    write(mFile.getInputStream(), new FileOutputStream(ctxPath+mFile.getOriginalFilename()));
//                    result.put(mFile.getName(), mFile.getOriginalFilename());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


//        return "上传成功：" + result.size() + "," + result.toString();
        return "上传成功：";
    }
}
