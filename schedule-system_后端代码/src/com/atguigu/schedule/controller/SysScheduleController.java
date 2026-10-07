package com.atguigu.schedule.controller;

import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;
import com.atguigu.schedule.service.impl.SysScheduleServiceimpl;
import com.atguigu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.schedule.common.Result;
/**
 * 增加日程的需求  /schedule/add
 * 修改日程的需求  /schedule/update
 * 查询日程的需求  /schedule/find
 * 删除日程的需求  /schedule/remove
 */

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //判断此次请求是增?删？改？查？
//        String requestURI = req.getRequestURI();
//        String[] split = requestURI.split("/");
//        String method = split[split.length - 1];
//        if (method.equals("add")) {
//            //增
//            add(req, resp);
//        }else if (method.equals("remove")) {
//            //删
//            remove(req, resp);
//        }else if (method.equals("update")) {
//            //改
//            update(req, resp);
//        }else if (method.equals("find")) {
//            //查
//            find(req, resp);
//        }
//    }
    private SysScheduleService scheduleService= new SysScheduleServiceimpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        //调用服务层，向数据库中增加一条空记录
        scheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));
    }


    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收请求体中的sid
        int sid = Integer.parseInt(req.getParameter("sid"));
        //调用服务层将信息更新进数据库
        scheduleService.removeSchedule(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        //查询用户的所有日程
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        //将用户的所有日程放入一个result对象
        Map data = new HashMap();
        data.put("itemList", itemList);
        Result result = Result.ok(data);
        //将result对象转换为json串响应给客户端
        WebUtil.writeJson(resp,result);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收请求体中的json串 转成一个SysSchedule对象
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        //调用服务层将信息更新进数据库
        scheduleService.updateSchedule(schedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }

}
