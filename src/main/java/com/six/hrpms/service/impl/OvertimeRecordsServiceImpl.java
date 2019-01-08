//package com.six.hrpms.service.impl;
//
//import com.six.hrpms.dao.OvertimeRecordsMapper;
//import com.six.hrpms.pojo.OvertimeRecords;
//import com.six.hrpms.service.OvertimeRecordsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OvertimeRecordsServiceImpl implements OvertimeRecordsService {
//
//    private OvertimeRecordsMapper overtimeRecordsMapper;
//
//    @Autowired
//    public OvertimeRecordsServiceImpl(OvertimeRecordsMapper overtimeRecordsMapper){
//        this.overtimeRecordsMapper = overtimeRecordsMapper;
//    }
//
//    @Override
//    public void addOvertimeRecords(OvertimeRecords overtimeRecords) {
//        overtimeRecordsMapper.insert(overtimeRecords);
//    }
//
//    @Override
//    public void deleteOvertimeRecords(OvertimeRecords overtimeRecords) {
//        overtimeRecordsMapper.deleteByPrimaryKey(overtimeRecords);
//    }
//
//    @Override
//    public void updateOvertimeRecords(OvertimeRecords overtimeRecords) {
//        overtimeRecordsMapper.updateByPrimaryKey(overtimeRecords);
//    }
//
//    @Override
//    public void selectOvertimeRecords(OvertimeRecords overtimeRecords) {
//        overtimeRecordsMapper.selectByPrimaryKey(overtimeRecords);
//    }
//
//}
