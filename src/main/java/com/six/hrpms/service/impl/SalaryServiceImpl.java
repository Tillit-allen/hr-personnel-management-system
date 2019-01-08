package com.six.hrpms.service.impl;

import com.six.hrpms.dao.*;
import com.six.hrpms.pojo.*;
import com.six.hrpms.service.SalaryService;
import com.six.hrpms.utils.DateAndStringTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: xkk
 * @Date: 2019/1/1 11:56
 */
@Service
public class SalaryServiceImpl implements SalaryService {

    //定义数据库查询类
    private final SalaryRecordMapper salaryRecordMapper;
    private final UserInfoMapper userInfoMapper;
    private final AttendanceRecordMapper attendanceRecordMapper;
    private final BusinessRecordMapper businessRecordMapper;
    private final LeaveRecordMapper leaveRecordMapper;
    private final OvertimeRecordsMapper overtimeRecordsMapper;

    /**
     * 实例化数据库查询类
     */
    @Autowired
    public SalaryServiceImpl(SalaryRecordMapper salaryRecordMapper, UserInfoMapper userInfoMapper, AttendanceRecordMapper attendanceRecordMapper, BusinessRecordMapper businessRecordMapper, LeaveRecordMapper leaveRecordMapper, OvertimeRecordsMapper overtimeRecordsMapper) {
        this.salaryRecordMapper = salaryRecordMapper;
        this.userInfoMapper = userInfoMapper;
        this.attendanceRecordMapper = attendanceRecordMapper;
        this.businessRecordMapper = businessRecordMapper;
        this.leaveRecordMapper = leaveRecordMapper;
        this.overtimeRecordsMapper = overtimeRecordsMapper;
    }


    @Override
    public List<SalaryRecord> findSalaryList(SalaryRecord salaryRecord, String userName, String bossName) {

        SalaryRecordExample salaryRecordExample = new SalaryRecordExample();
        SalaryRecordExample.Criteria criteria = salaryRecordExample.createCriteria();
//        salaryRecordExample.setOrderByClause("end_time desc");

        if (salaryRecord != null) {
            if (salaryRecord.getUserId() != null) {
                criteria.andUserIdEqualTo(salaryRecord.getUserId());
            }
            if (salaryRecord.getStartTime() != null) {
                criteria.andStartTimeGreaterThanOrEqualTo(salaryRecord.getStartTime());
            }
            if (salaryRecord.getEndTime() != null) {
                criteria.andEndTimeLessThanOrEqualTo(salaryRecord.getEndTime());
            }
        }
        List<String> list = new ArrayList<String>();
        if (userName != null && !"".equals(userName)) {
            list.addAll(userInfoListToId(selectUserInfoByUserName(userName)));
        }
        if (bossName != null && !"".equals(bossName)) {
            list.addAll(userInfoListToId(selectUserInfoByBossName(bossName)));
        }
        if (list.size() > 0) {
            criteria.andUserIdIn(list);
        }

        return salaryRecordMapper.selectByExample(salaryRecordExample);
    }

    /**
     * 通过用户名称查询用户信息
     *
     * @param userName 用户名称
     * @return 查询到的用户列表
     */
    private List<UserInfo> selectUserInfoByUserName(String userName) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

        criteria.andUserNameEqualTo(userName);

        return userInfoMapper.selectByExample(userInfoExample);
    }


    /**
     * 通过老板名称名称查询用户信息
     *
     * @param bossName 老板名称
     * @return 查询到的用户列表
     */
    private List<UserInfo> selectUserInfoByBossName(String bossName) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

        criteria.andBossNameEqualTo(bossName);

        return userInfoMapper.selectByExample(userInfoExample);
    }

    private List<String> userInfoListToId(List<UserInfo> list) {

        List<String> list1 = new ArrayList<String>();

        for (UserInfo userInfo : list) {
            list1.add(userInfo.getUserId());
        }

        return list1;

    }

    @Override
    public SalaryRecord findSalaryListById(Integer id) {
        return salaryRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer payoff(List<String> userIds, Double bonus) {

        int num = 0;

        for (String userId : userIds) {
            if (paySalary(userId, bonus)) {
                num++;
            }
        }

        return num;
    }

    @Override
    public Integer payoff(Double bonus) {

        List<UserInfo> userInfos = userInfoMapper.selectByExample(new UserInfoExample());

        int num = 0;

        for (UserInfo userInfo : userInfos) {
            if (paySalary(userInfo.getUserId(), bonus)) {
                num++;
            }
        }

        return num;
    }

    /**
     * 支付工资
     *
     * @return 成功: true
     * 失败: false
     */
    private Boolean paySalary(String userId, Double bonus) {

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);

        //获取员工工资(每小时)
        double salaryHour = userInfo.getBasicSalary() * 1.0 / userInfo.getBasicWorkTime();
        //获取员工工资(每分钟)
        double salaryMin = userInfo.getBasicSalary() * 1.0 / userInfo.getBasicWorkTime() / 60;
        //获取员工工资(每天)
        double salaryDay = (userInfo.getBasicWorkTime() / 30) * userInfo.getBasicSalary() * 1.0 / userInfo.getBasicWorkTime();

        SalaryRecord salaryRecord1 = new SalaryRecord();
        salaryRecord1.setWorkTime(0.0);
        salaryRecord1.setOvertimeTime(0.0);
        salaryRecord1.setBusinessTime(0.0);
        salaryRecord1.setLeaveTime(0.0);
        salaryRecord1.setBusinessMoney(0.0);
        salaryRecord1.setLateTime(0.0);
        salaryRecord1.setLeaveEarlyTime(0.0);

        payBefore();

        //获取考勤记录
        Date date = attendanceRecordSalary(userInfo, salaryRecord1);

        //获取加班记录
        salaryRecord1.setOvertimeTime(Double.valueOf(overtimeRecordSalary(userInfo, date)));

        //获取出差记录
        salaryRecord1.setBusinessTime(Double.valueOf(businessRecordSalary(userInfo, date, salaryRecord1)));

        //获取请假记录
        salaryRecord1.setLeaveTime(Double.valueOf(leaveRecordSalary(userInfo, date)));

        payLater();

        //计算最后薪资
        Double salary = salaryRecord1.getWorkTime() * salaryMin +
                salaryRecord1.getOvertimeTime() * salaryMin +
                salaryRecord1.getLeaveTime() * salaryDay / 2 +
                salaryRecord1.getBusinessTime() * salaryDay +
                salaryRecord1.getBusinessMoney() -
                salaryRecord1.getLateTime() * 10 -
                salaryRecord1.getLeaveEarlyTime() * 10;

        if (bonus != null) {
            salary += bonus;
        }

        //设置薪资参数
        salaryRecord1.setUserId(userId);
        salaryRecord1.setStartTime(userInfo.getSalaryTime());
        salaryRecord1.setEndTime(date);
        salaryRecord1.setSalary(salary);

        //插入薪资数据
        salaryRecordMapper.insertSelective(salaryRecord1);
        //更新UserInfo表-------------------------------------------/
        userInfo.setSalaryTime(date);
        userInfoMapper.updateByPrimaryKey(userInfo);
        return true;
    }


    /**
     * 获取考勤信息
     *
     * @param user         用户
     * @param salaryRecord 工作总时长,迟到次数,早退次数
     * @return 薪资计算最后时间
     */
    private Date attendanceRecordSalary(UserInfo user, SalaryRecord salaryRecord) {

        //获取当前时间的前一天凌晨4点的时间
        Date now = new Date();
        Date start = user.getSalaryTime();
        Date end = DateAndStringTransform.getNextDay4Points(start);

        while (end.getTime() <= now.getTime()) {
            //上午迟到
            Boolean amBeLater = true;
            //上午早退
//            Boolean amLeaverEarly = true;
            //下午迟到
//            Boolean pmBeLater = true;
            //下午早退
            Boolean pmLeaverEarly = true;

            //当天上班记录
            List<AttendanceRecord> goTo = findAttendanceRecords(user, start, end, "上班");
            //当天下班记录
            List<AttendanceRecord> gotOff = findAttendanceRecords(user, start, end, "下班");

            if (goTo.size() != gotOff.size()) {
                new RuntimeException("上班记录与下班记录数量不匹配");
            }

            //上班时间
            /**
             * 注释区为上下午班制度
             */
            String amStartTime = "08:00";
//            String amEndTime = "12:00";
//            String pmStartTime = "14:00";
            String pmEndTime = "18:00";
            String startTime = amStartTime;
//            String endTime = amEndTime;
            String endTime = pmEndTime;
//            Boolean isAm = true;
            for (int i = 0; i < goTo.size(); i++) {
                //迟到
                Integer later = DateAndStringTransform.judgmentPeriod1(goTo.get(i).getTime(), startTime, endTime);
//                if (later == 3) {
//                    isAm = false;
//                    startTime = pmStartTime;
//                    endTime = pmEndTime;
//                    later = DateAndStringTransform.judgmentPeriod(goTo.get(i).getTime(), startTime, endTime);
//                }
                //早退
                Integer before = DateAndStringTransform.judgmentPeriod1(gotOff.get(i).getTime(), startTime, endTime);
                if (later == 1) {
//                    if (isAm) {
                    amBeLater = false;
//                    } else {
//                        pmBeLater = false;
//                    }
                }
                if (before == 3) {
//                    if (isAm) {
//                        amLeaverEarly = false;
//                    } else {
                    pmLeaverEarly = false;
//                    }
                }

                //计算工作的时长(分钟)
                salaryRecord.setWorkTime(salaryRecord.getWorkTime() + DateAndStringTransform.calculateTheTimeDifferenceAndMinute(goTo.get(i).getTime(), gotOff.get(i).getTime()));
            }

            //判断是否迟到/早退...
            if (amBeLater) {
                salaryRecord.setLateTime(salaryRecord.getLateTime() + 1);
//                    laterTime++;
            }
//                if (pmBeLater) {
//                    lateTime++;
//                }
//                if (amLeaverEarly) {
//                    beforeTime++;
//                }
            if (pmLeaverEarly) {
                salaryRecord.setLeaveEarlyTime(salaryRecord.getLeaveEarlyTime() + 1);
//                    beforeTime++;
            }
            start = end;
            end = DateAndStringTransform.getNextDay4Points(end);
        }
        //回溯时间
        end = DateAndStringTransform.getLastDay4Points(end);
        return end;
    }

    /**
     * 加班
     *
     * @param user 用户信息
     * @param end  计算结束时间
     * @return 加班时长
     */
    private Long overtimeRecordSalary(UserInfo user, Date end) {
        Long workTime = 0L;
        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();

        criteria.andUserIdEqualTo(user.getUserId());
        criteria.andStartTimeGreaterThanOrEqualTo(user.getSalaryTime());
        criteria.andEndTimeLessThanOrEqualTo(end);
        //审核状态
        criteria.andAuditStatusEqualTo(2);


        List<OvertimeRecords> overtimeRecords = overtimeRecordsMapper.selectByExample(overtimeRecordsExample);

        for (OvertimeRecords records : overtimeRecords) {
            workTime += DateAndStringTransform.calculateTheTimeDifferenceAndMinute(records.getStartTime(), records.getEndTime());
        }

        return workTime;
    }

    /**
     * 获取出差记录
     *
     * @param userInfo 用户
     * @param end      结束时间
     * @return
     */
    private int businessRecordSalary(UserInfo userInfo, Date end, SalaryRecord salaryRecord) {

        BusinessRecordExample example = new BusinessRecordExample();
        BusinessRecordExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userInfo.getUserId());
        criteria.andStartTimeGreaterThanOrEqualTo(userInfo.getSalaryTime());
        criteria.andEndTimeLessThanOrEqualTo(end);
        //审核状态
        criteria.andAuditStatusEqualTo(2);

        List<BusinessRecord> records = businessRecordMapper.selectByExample(example);

        int time = 0;
        for (BusinessRecord record : records) {
            //出差经费
            salaryRecord.setBusinessMoney(salaryRecord.getBusinessMoney() + record.getMoney());
            //出差时间
            Date nextDay = record.getStartTime();
            while (nextDay.getTime() <= record.getEndTime().getTime()) {
                nextDay = DateAndStringTransform.getNextDay4Points(nextDay);
                time++;
            }
        }
        return time;
    }

    /**
     * 请病假
     *
     * @param userInfo 用户
     * @param end      结束时间
     * @return 请假天数
     */
    private int leaveRecordSalary(UserInfo userInfo, Date end) {
        LeaveRecordExample example = new LeaveRecordExample();
        LeaveRecordExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userInfo.getUserId());
        criteria.andStartTimeGreaterThanOrEqualTo(userInfo.getSalaryTime());
        criteria.andEndTimeLessThanOrEqualTo(end);
        criteria.andTypeEqualTo("病假");
        //审核状态
        criteria.andAuditStatusEqualTo("2");

        List<LeaveRecord> records = leaveRecordMapper.selectByExample(example);

        int time = 0;
        for (LeaveRecord record : records) {
            //出差时间
            Date nextDay = record.getStartTime();
            while (nextDay.getTime() <= record.getEndTime().getTime()) {
                nextDay = DateAndStringTransform.getNextDay4Points(nextDay);
                time++;
            }
        }
        return time;
    }

    /**
     * 获取考勤记录
     *
     * @param user   考勤人员
     * @param start  开始时间
     * @param end    结束时间
     * @param status 考勤状态("上班","下班")
     * @return 查询结果
     */
    @Override
    public List<AttendanceRecord> findAttendanceRecords(UserInfo user, Date start, Date end, String status) {

        //查询该用户的上下班记录(工资计算时间段)
        AttendanceRecordExample example1 = new AttendanceRecordExample();
        AttendanceRecordExample.Criteria criteria = example1.createCriteria();
        example1.setOrderByClause("time asc");

        criteria.andUserIdEqualTo(user.getUserId());
        criteria.andTimeBetween(start, end);
        criteria.andStatusEqualTo(status);

        //上/下班记录
        return attendanceRecordMapper.selectByExample(example1);
    }

    /**
     * 用于后期在支付之前执行的函数,继承并重写该类在paySalary()执行之前执行相应操作
     */
    void payBefore() {
    }

    /**
     * 用于后期在支付之后执行的函数,继承并重写该类在paySalary()执行之后执行相应操作
     */
    void payLater() {
    }

}
