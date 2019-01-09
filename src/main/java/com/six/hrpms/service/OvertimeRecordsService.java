package com.six.hrpms.service;

import com.six.hrpms.pojo.OvertimeRecords;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OvertimeRecordsService {

      void addOvertimeRecords(OvertimeRecords overtimeRecords);

      Integer deleteOvertimeRecords(OvertimeRecords overtimeRecords);

      void updateOvertimeRecords(OvertimeRecords overtimeRecords);

      List<OvertimeRecords> getApplyOvertime(String userId);

      List<OvertimeRecords> getApplyOvertimeRecords();

      List<OvertimeRecords> selectOvertimeRecordsByuserId(String keyword);

      int checkOvertime(OvertimeRecords overtimeRecords);

      OvertimeRecords selectOvertime(OvertimeRecords overtimeRecords);
}

