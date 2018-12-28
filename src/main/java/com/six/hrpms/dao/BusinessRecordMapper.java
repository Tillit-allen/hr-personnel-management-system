package com.six.hrpms.dao;

import com.six.hrpms.pojo.BusinessRecord;
import com.six.hrpms.pojo.BusinessRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessRecordMapper {
    int countByExample(BusinessRecordExample example);

    int deleteByExample(BusinessRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessRecord record);

    int insertSelective(BusinessRecord record);

    List<BusinessRecord> selectByExample(BusinessRecordExample example);

    BusinessRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessRecord record, @Param("example") BusinessRecordExample example);

    int updateByExample(@Param("record") BusinessRecord record, @Param("example") BusinessRecordExample example);

    int updateByPrimaryKeySelective(BusinessRecord record);

    int updateByPrimaryKey(BusinessRecord record);
}