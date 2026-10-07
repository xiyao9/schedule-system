package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

public interface SysUserDao {
    /**
     * 向数据库中存放用户信息的方法
     * @param sysUser 向数据库中增加一条用户记录，增加用户名和密码，以sysUser对象的形式接受
     * @return 增加成功返回1 增加失败返回0
     */
    int addSysuser(SysUser sysUser);

    SysUser findByUsername(String username);
}
