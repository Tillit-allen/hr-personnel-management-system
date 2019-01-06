package com.six.hrpms.service;
import com.six.hrpms.pojo.AttendanceRecord;

import java.util.Date;
import java.util.List;

public interface AttendanceRecordService {
    /**************************用户功能*********************************/
    /**
     * 根据用户id查询签到信息
     * @return
     */
    List<AttendanceRecord> selectAttendanceRecordList(AttendanceRecord attendanceRecord);
    /**
     * 根据时间来查询用户信息
     * @param attendanceRecord
     * @return
     */
    List<AttendanceRecord> selectAttendanceRecordList1(AttendanceRecord attendanceRecord,Date date1,Date date2);
    /**
     * 添加用户签到信息
     * @param attendanceRecord
     */
    void insertAttendanceRecord(AttendanceRecord attendanceRecord);
    /**
     * 获取时间段签到记录
     * @param attendanceRecord
     * @return
     */
    int selectTime(AttendanceRecord attendanceRecord,Date date1);
    /****************************管理员功能******************************************/
    /**
     * 查询所有用户的签到信息
     * @return 返回签到信息
     */
    List<AttendanceRecord> findAllAttendanceRecordList();

    /**
     * 根据用户id和时间来查询
     * @return
     */
    List<AttendanceRecord> getUserAttendanceRecord(String userid,Date date1,Date date2);
}
