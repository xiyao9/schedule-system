package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.common.ResultCodeEnum;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceimpl;
import com.atguigu.schedule.util.MD5Util;
import com.atguigu.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class UserController extends BaseController {

    private SysUserService userService = new SysUserServiceimpl();

    /**
     * 该方法用来处理注册业务（是一个业务接口
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受json请求参数转为user对象
        SysUser registUser = WebUtil.readJson(req, SysUser.class);



        //调用服务层处理

        int rows = userService.regist(registUser);
        //做出响应
        Result result = Result.ok(null);
        if(rows<1){
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }


    /**
     * 该方法用来处理登录业务是一个业务接口
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名和密码
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        //调用服务层在数据库中查询是否有该用户
        SysUser loginUser = userService.findByUsername(sysUser.getUsername());
        Result result = Result.ok(null);
        if (loginUser == null) {
            result=Result.build(null,ResultCodeEnum.USERNAME_ERROR);
            //判断密码是否正确
        } else if (!MD5Util.encrypt(sysUser.getUserPwd()).equals(loginUser.getUserPwd())) {
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else{
            Map data =new HashMap();
            loginUser.setUserPwd("");
            data.put("loginUser",loginUser);
           result=Result.ok(data);
        }
        //将登录结果响应给客户端
        WebUtil.writeJson(resp,result);

    }

    /**
     * 该方法用来校验数据库中是否有新创建的用户名
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名
        String username = req.getParameter("username");
        //调用服务层业务处理方法查询该名是否在数据库中存在相同名称
        SysUser sysUser = userService.findByUsername(username);
        //响应
        Result result = Result.ok(null);
        if (sysUser != null) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //将resul对象转为JSON串响应
        ObjectMapper objectMapper = new ObjectMapper();
        String info = objectMapper.writeValueAsString(result);
        //告诉客户端响应给你的是json串
        WebUtil.writeJson(resp,result);
    }
}
