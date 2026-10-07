package com.atguigu.schedule.filter;

import com.atguigu.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//@WebFilter(urlPatterns = {"/schedule/*","/showSchedule.html"})
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获得session域对象
        HttpSession session = req.getSession();
        //从session域对象中获得用户对象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");
        //校验用户对象是否为空
        if (sysUser == null) {
            //空 转向login.html
            resp.sendRedirect("/login.html");
        }else {
            //否 放行
            filterChain.doFilter(req, resp);
        }


    }
}

