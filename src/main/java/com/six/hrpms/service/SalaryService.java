package com.six.hrpms.service;

import com.six.hrpms.pojo.AttendanceRecord;
import com.six.hrpms.pojo.SalaryRecord;
import com.six.hrpms.pojo.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * @author: xkk
 * @Date: 2019/1/1 11:02
 */
public interface SalaryService {


    /**
     * 查询薪资列表
     *
     * @param salaryRecord 用于存储查询条件(用户id,开始/结束时间)
     *                     注:皆可为空,为空表示不凭该条件查询
     * @param userName     用户名.通过用户名查询.
     * @return 成功: 信息列表
     * 失败: null
     */
    List<SalaryRecord> findSalaryList(SalaryRecord salaryRecord, String userName, String bossName);

    /**
     * 根据薪资id,查询薪资详情
     *
     * @param id 薪资id
     * @return 成功: 薪资详情
     * 失败: null
     */
    SalaryRecord findSalaryListById(Integer id);

    /**
     * 支付工资
     *
     * @param userIds 用户id列表
     * @param bonus 奖金
     * @return 成功发工资人数.
     */
    Integer payoff(List<String> userIds,Double bonus);

    /**
     * 发送所有员工工资
     *
     * @return 成功发工资数量.
     */
    Integer payoff(Double bonus);


    List<AttendanceRecord> findAttendanceRecords(UserInfo user, Date start, Date end, String status);
}
