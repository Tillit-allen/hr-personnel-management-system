package com.six.hrpms.dao;

import com.six.hrpms.pojo.AttendanceRecord;
import com.six.hrpms.pojo.AttendanceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceRecordMapper {
    int countByExample(AttendanceRecordExample example);

    int deleteByExample(AttendanceRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(AttendanceRecord record);

    int insertSelective(AttendanceRecord record);

    List<AttendanceRecord> selectByExample(AttendanceRecordExample example);

    AttendanceRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AttendanceRecord record, @Param("example") AttendanceRecordExample example);

    int updateByExample(@Param("record") AttendanceRecord record, @Param("example") AttendanceRecordExample example);

    int updateByPrimaryKeySelective(AttendanceRecord record);

    int updateByPrimaryKey(AttendanceRecord record);
}