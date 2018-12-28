package com.six.hrpms.dao;

import com.six.hrpms.pojo.SalaryRecord;
import com.six.hrpms.pojo.SalaryRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalaryRecordMapper {
    int countByExample(SalaryRecordExample example);

    int deleteByExample(SalaryRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalaryRecord record);

    int insertSelective(SalaryRecord record);

    List<SalaryRecord> selectByExample(SalaryRecordExample example);

    SalaryRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalaryRecord record, @Param("example") SalaryRecordExample example);

    int updateByExample(@Param("record") SalaryRecord record, @Param("example") SalaryRecordExample example);

    int updateByPrimaryKeySelective(SalaryRecord record);

    int updateByPrimaryKey(SalaryRecord record);
}