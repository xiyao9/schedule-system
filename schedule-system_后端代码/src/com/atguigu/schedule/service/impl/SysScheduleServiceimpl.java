package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoimpl;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceimpl implements SysScheduleService {
    private SysScheduleDao scheduleDao = new SysScheduleDaoimpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefult(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return scheduleDao.removeSchedule(sid);
    }


}
