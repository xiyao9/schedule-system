package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {


    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefult(int uid);

    Integer updateSchedule(SysSchedule schedule);


    Integer removeSchedule(int sid);
}
