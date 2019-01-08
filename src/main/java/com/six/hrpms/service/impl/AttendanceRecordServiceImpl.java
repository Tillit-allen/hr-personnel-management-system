package com.six.hrpms.service.impl;
import com.six.hrpms.dao.AttendanceRecordMapper;
import com.six.hrpms.pojo.AttendanceRecord;
import com.six.hrpms.pojo.AttendanceRecordExample;
import com.six.hrpms.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("attendanceRecordService")
public class AttendanceRecordServiceImpl implements AttendanceRecordService {

    @Autowired
    private AttendanceRecordMapper attendanceRecordMapper;


/***************************************用户功能********************************************************/
    /**
     *根据id查询用户信息
     */
    @Override
    public List<AttendanceRecord> selectAttendanceRecordList(AttendanceRecord attendanceRecord){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        attendanceRecordExample.setOrderByClause("time asc");
        criteria.andIdIsNotNull();
        criteria.andUserIdEqualTo(attendanceRecord.getUserId());   //按照user_id的值来查询
        List<AttendanceRecord> attendanceRecordList = attendanceRecordMapper.selectByExample(attendanceRecordExample);
        return attendanceRecordList;
    }

    /**
     * 根据时间段来查询用户信息
     * @param attendanceRecord
     * @param date1
     * @param date2
     * @return
     */
    public List<AttendanceRecord> selectAttendanceRecordList1(AttendanceRecord attendanceRecord,Date date1,Date date2){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        criteria.andUserIdEqualTo(attendanceRecord.getUserId());   //按照user_id的值来查询
        criteria.andTimeBetween(date1,date2);
        attendanceRecordExample.setOrderByClause("time asc");
        List<AttendanceRecord> attendanceRecordList = attendanceRecordMapper.selectByExample(attendanceRecordExample);
        return attendanceRecordList;
    }
    /**
     * 获取时间段的记录条数
     * @param attendanceRecord
     * @param date1
     * @return
     */
    @Override
    public int selectTime(AttendanceRecord attendanceRecord, Date date1){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        criteria.andUserIdEqualTo(attendanceRecord.getUserId());
        criteria.andTimeGreaterThanOrEqualTo(date1); //获取时间段之内的记录
        int number = attendanceRecordMapper.countByExample(attendanceRecordExample);
        return number;
    }


    /**
     * 签到或者签退
     * @param attendanceRecord
     */
    @Override
    public void insertAttendanceRecord(AttendanceRecord attendanceRecord){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        criteria.andUserIdEqualTo(attendanceRecord.getUserId());  //根据user_id的值来判断用户
        try {
            attendanceRecordMapper.insertSelective(attendanceRecord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入数据异常");
        }
    }

/***********************************管理员功能*******************************************************/
    /**
     * 查询所有用户签到信息
     * @return 签到信息
     */
    @Override
    public List<AttendanceRecord> findAllAttendanceRecordList(){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        attendanceRecordExample.setOrderByClause("time asc");
        criteria.andIdIsNotNull();
        List<AttendanceRecord> attendanceRecordList = attendanceRecordMapper.selectByExample(attendanceRecordExample);
        return attendanceRecordList;
    }

    @Override
    public List<AttendanceRecord> getUserAttendanceRecord(String userid,Date date1,Date date2){
        AttendanceRecordExample attendanceRecordExample = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = attendanceRecordExample.createCriteria();
        attendanceRecordExample.setOrderByClause("time asc");
        criteria.andUserIdEqualTo(userid);
        criteria.andTimeBetween(date1,date2);
        List<AttendanceRecord> attendanceRecordList = attendanceRecordMapper.selectByExample(attendanceRecordExample);
        return attendanceRecordList;
    }
}
