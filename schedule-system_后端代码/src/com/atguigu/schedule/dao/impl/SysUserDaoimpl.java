package com.atguigu.schedule.dao.impl;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoimpl extends BaseDao implements SysUserDao {


    @Override
    public int addSysuser(SysUser sysUser) {
        String sql = "insert into sys_user VALUES(DEFAULT,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username=?";
        List<SysUser> userList = baseQuery(SysUser.class, sql, username);
        return userList != null && userList.size() > 0 ? userList.get(0) : null;
    }
}
