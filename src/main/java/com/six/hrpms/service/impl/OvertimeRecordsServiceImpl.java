package com.six.hrpms.service.impl;

import com.six.hrpms.dao.OvertimeRecordsMapper;
import com.six.hrpms.pojo.OvertimeRecords;
import com.six.hrpms.pojo.OvertimeRecordsExample;
import com.six.hrpms.service.OvertimeRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OvertimeRecordsServiceImpl implements OvertimeRecordsService {

    private OvertimeRecordsMapper overtimeRecordsMapper;

    @Autowired
    public OvertimeRecordsServiceImpl(OvertimeRecordsMapper overtimeRecordsMapper){
        this.overtimeRecordsMapper = overtimeRecordsMapper;
    }

    /*
    添加
     */
    @Override
    public void addOvertimeRecords(OvertimeRecords overtimeRecords) {
        overtimeRecordsMapper.insert(overtimeRecords);
    }

    /*
    删除申请信息
     */
    @Override
    public Integer deleteOvertimeRecords(OvertimeRecords overtimeRecords) {
        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();
        criteria.andUserIdEqualTo(overtimeRecords.getUserId());
       return overtimeRecordsMapper.deleteByExample(overtimeRecordsExample);

    }

    @Override
    public void updateOvertimeRecords(OvertimeRecords overtimeRecords) {
        overtimeRecordsMapper.updateByPrimaryKey(overtimeRecords);
    }


    /*
    管理员 员工信息显示
     */
    @Override
    public List<OvertimeRecords> getApplyOvertimeRecords() {
        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();
        criteria.andAuditStatusEqualTo(0);
        List<OvertimeRecords> overtimeRecords = overtimeRecordsMapper.selectByExample(overtimeRecordsExample);
        return overtimeRecords;
    }


    /*
    员工信息显示
     */
    @Override
    public List<OvertimeRecords> getApplyOvertime() {
        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();
        criteria.andIdIsNotNull();
        List<OvertimeRecords> overtimeRecords = overtimeRecordsMapper.selectByExample(overtimeRecordsExample);
        return overtimeRecords;
    }



//    @Override
//    public List<OvertimeRecords> getApplyOvertimeRecords1(OvertimeRecords overtimeRecords) {
//        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
//        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();
//        criteria.andUserIdEqualTo(overtimeRecords.getUserId());
//        List<OvertimeRecords> overtimeRecords1 = overtimeRecordsMapper.selectByExample(overtimeRecordsExample);
//        return  overtimeRecords1;
//    }


    @Override
    public int checkOvertime(OvertimeRecords overtimeRecords) {
        return overtimeRecordsMapper.updateByPrimaryKeySelective(overtimeRecords);
    }

    /**
     * 员工信息查询
     */
    @Override
    public List<OvertimeRecords> selectOvertimeRecords(OvertimeRecords overtimeRecords) {
        OvertimeRecordsExample overtimeRecordsExample = new OvertimeRecordsExample();
        OvertimeRecordsExample.Criteria criteria = overtimeRecordsExample.createCriteria();
        criteria.andUserIdLike(overtimeRecords.getUserId());
        List<OvertimeRecords> list = overtimeRecordsMapper.selectByExample(overtimeRecordsExample);
        return list;
    }


}
