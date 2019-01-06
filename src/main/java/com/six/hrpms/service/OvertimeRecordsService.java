package com.six.hrpms.service;

import com.six.hrpms.pojo.OvertimeRecords;
import org.springframework.stereotype.Service;

@Service
public interface OvertimeRecordsService {

      void addOvertimeRecords(OvertimeRecords overtimeRecords);

      void deleteOvertimeRecords(OvertimeRecords overtimeRecords);

      void updateOvertimeRecords(OvertimeRecords overtimeRecords);

      void selectOvertimeRecords(OvertimeRecords overtimeRecords);
}

