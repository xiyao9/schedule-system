package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.dao.impl.SysUserDaoimpl;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.util.MD5Util;

public class SysUserServiceimpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoimpl();
    @Override
    public int regist(SysUser sysUser) {
        //将用户的明文密码转为加密密码
        String userPwd = sysUser.getUserPwd();
        String encrypt = MD5Util.encrypt(userPwd);
        sysUser.setUserPwd(encrypt);
        //调用dao层 把信息放入数据库
        return userDao.addSysuser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
