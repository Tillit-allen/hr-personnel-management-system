package com.six.hrpms.dao;

import com.six.hrpms.pojo.OvertimeRecords;
import com.six.hrpms.pojo.OvertimeRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OvertimeRecordsMapper {
    int countByExample(OvertimeRecordsExample example);

    int deleteByExample(OvertimeRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OvertimeRecords record);

    int insertSelective(OvertimeRecords record);

    List<OvertimeRecords> selectByExample(OvertimeRecordsExample example);

    OvertimeRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OvertimeRecords record, @Param("example") OvertimeRecordsExample example);

    int updateByExample(@Param("record") OvertimeRecords record, @Param("example") OvertimeRecordsExample example);

    int updateByPrimaryKeySelective(OvertimeRecords record);

    int updateByPrimaryKey(OvertimeRecords record);
}