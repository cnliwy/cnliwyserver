package com.liwy.server.controllers;

import com.liwy.server.entity.PlanData;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liwy on 2017/7/19.
 */
@RequestMapping("/plan")
@Controller
public class PlanController {

    @RequestMapping("/list")
    public Object getPlans(HttpSession httpSession){
        List<PlanData> planDatas = new ArrayList<PlanData>();
        planDatas.add(new PlanData(20,"计划1","内容1","1","1",new Date(),new Date()));
        planDatas.add(new PlanData(20,"计划2","内容2","1","1",new Date(),new Date()));
        planDatas.add(new PlanData(20,"计划3","内容3","1","1",new Date(),new Date()));
        ModelAndView modelAndView = new ModelAndView("plan/list");
        modelAndView.addObject("planDatas",planDatas);
        modelAndView.addObject("menu","planList");
        modelAndView.addObject("plan","list");
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public Object toAdd(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("plan/add");
        modelAndView.addObject("menu","planAdd");
        modelAndView.addObject("plan","add");
        return modelAndView;
    }

    @RequestMapping("/addPlan")
    public Object addPlan(HttpSession session,@RequestParam(required = false)PlanData plan){
        System.out.println("添加新计划:" + plan.toString());
        ModelAndView modelAndView = new ModelAndView("plan/add");
        modelAndView.addObject("menu","planAdd");
        modelAndView.addObject("plan","add");
        return modelAndView;
    }

    @RequestMapping("/editPlan")
    public Object editPlan(HttpSession session,PlanData planData){
        return "";
    }

    @RequestMapping("/deletePlan")
    public Object deletePlan(HttpSession session,String planId){
        return "";
    }

}
