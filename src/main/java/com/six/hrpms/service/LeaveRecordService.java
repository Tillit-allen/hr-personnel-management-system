package com.six.hrpms.service;

import com.six.hrpms.pojo.LeaveRecord;

import java.util.List;

public interface LeaveRecordService {
    //上司查询所有
    public List<LeaveRecord> findAllList();
    //上司按用户id查询
    public List<LeaveRecord> findByuserId(LeaveRecord leaveRecord);
    //上司修改审核状态
    public void CheckLeaveRecord(LeaveRecord leaveRecord);
    //用户申请请假
    public void insertLeaveRecord(LeaveRecord leaveRecord);
    //用户修改请假信息
    public void updateLeaveRecord(LeaveRecord leaveRecord);
    //用户按请假ID删除（取消申请请假）
    public void deleteById(LeaveRecord leaveRecord);


    //
}
