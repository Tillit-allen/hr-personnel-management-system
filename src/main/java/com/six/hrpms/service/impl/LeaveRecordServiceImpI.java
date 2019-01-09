package com.six.hrpms.service.impl;


import com.six.hrpms.dao.LeaveRecordMapper;
import com.six.hrpms.pojo.LeaveRecord;
import com.six.hrpms.pojo.LeaveRecordExample;
import com.six.hrpms.service.LeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("LeaveRecordService")
public class LeaveRecordServiceImpI implements LeaveRecordService {
    @Autowired
    private LeaveRecordMapper leaveRecordMapper;

    /**
     * 查询所有的收录工具
     *
     * @return 返回所有的收录工具的集合
     */

    //上司浏览所有请假记录
    @Override
    public List<LeaveRecord> findAllList(Date start, Date end) {
        //通过Criteria查询对象查询的四个步骤：

        //1.创建一个IncludeToolExample对象
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        //2.通过example类中的createCriteria()创建一个criteria对象
        LeaveRecordExample.Criteria criteria = leaveRecordExample.createCriteria();
        //3.给criteria对象增加查询条件
        criteria.andIdIsNotNull();  //创建id列不为空的条件，即可表示查询所有的值

        if (start != null) {
            criteria.andStartTimeGreaterThanOrEqualTo(start);
        }
        if (end != null) {
            criteria.andEndTimeLessThanOrEqualTo(end);
        }

        //4.调selectByExample方法查询满足条件的结果集存放到集合中
        List<LeaveRecord> findAllList = leaveRecordMapper.selectByExample(leaveRecordExample);
        return findAllList;
    }

    //上司按员工ID查找请假记录
    @Override
    public List<LeaveRecord> findByUserId(String userId, Date start, Date end) {
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        LeaveRecordExample.Criteria criteria = leaveRecordExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        if (start != null) {
            criteria.andStartTimeGreaterThanOrEqualTo(start);
        }
        if (end != null) {
            criteria.andEndTimeLessThanOrEqualTo(end);
        }

        List<LeaveRecord> findByUserId = leaveRecordMapper.selectByExample(leaveRecordExample);
        return findByUserId;
    }

    @Override
    public LeaveRecord findLeaveRecordById(Integer id) {
        return leaveRecordMapper.selectByPrimaryKey(id);
    }

    //上司审核
    @Override
    public void CheckLeaveRecord(LeaveRecord leaveRecord) {
        leaveRecordMapper.updateByPrimaryKeySelective(leaveRecord);
    }

    //员工取消申请请假(按请假编号)
    @Override
    public void deleteById(LeaveRecord leaveRecord) {
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        LeaveRecordExample.Criteria criteria = leaveRecordExample.createCriteria();
        criteria.andIdEqualTo(leaveRecord.getId());
        leaveRecordMapper.deleteByExample(leaveRecordExample);
    }


    //员工申请请假
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Override
    public void insertLeaveRecord(LeaveRecord leaveRecord) {

            leaveRecordMapper.insertSelective(leaveRecord);

    }

    //员工修改请假信息
    @Override
    public void updateLeaveRecord(LeaveRecord leaveRecord) {

        try {
            leaveRecordMapper.updateByPrimaryKeySelective(leaveRecord);
            //updateByPrimaryKeySelective方法表示通过主键更新属性值不为null的列
        } catch (Exception e) {
            //e.printStackTrace();
            if (leaveRecord.getReason() == null) {
                throw new RuntimeException("原因空");
            } else if (leaveRecord.getStartTime() == null) {
                throw new RuntimeException("开始时间空");
            } else if (leaveRecord.getEndTime() == null) {
                throw new RuntimeException("结束时间空");
            }
            throw new RuntimeException("更新数据异常");
        }
    }
}
