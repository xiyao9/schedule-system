package com.atguigu.schedule.service;


import com.atguigu.schedule.pojo.SysUser;

/**
 * 该接口负责sys_user表的业务处理
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     *
     * @param sysUser 要注册的用户名和明文密码以sysUsers对象的形式注册
     * @return 注册成功返回1 注册失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名返回用户信息的方法
     * @param username 要查询的用户名
     * @return 查询成功返回用户信息，查询失败返回null
     */
    SysUser findByUsername(String username);
}
