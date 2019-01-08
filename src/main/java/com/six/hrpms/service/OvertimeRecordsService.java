package com.six.hrpms.service;

import com.six.hrpms.pojo.OvertimeRecords;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OvertimeRecordsService {

      void addOvertimeRecords(OvertimeRecords overtimeRecords);

      Integer deleteOvertimeRecords(OvertimeRecords overtimeRecords);

      void updateOvertimeRecords(OvertimeRecords overtimeRecords);

      List<OvertimeRecords> getApplyOvertime();

      List<OvertimeRecords> getApplyOvertimeRecords();

      List<OvertimeRecords> selectOvertimeRecords(OvertimeRecords overtimeRecords);

      int checkOvertime(OvertimeRecords overtimeRecords);
}

