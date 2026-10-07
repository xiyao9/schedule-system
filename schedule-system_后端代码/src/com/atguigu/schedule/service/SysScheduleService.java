package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 该接口负责sys_schedule表的业务处理
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);


    Integer removeSchedule(int sid);
}
