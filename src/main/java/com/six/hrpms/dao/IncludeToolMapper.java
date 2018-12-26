package com.six.hrpms.dao;

import com.six.hrpms.pojo.IncludeTool;
import com.six.hrpms.pojo.IncludeToolExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncludeToolMapper {
    int countByExample(IncludeToolExample example);

    int deleteByExample(IncludeToolExample example);

    int deleteByPrimaryKey(Integer includeToolId);

    int insert(IncludeTool record);

    int insertSelective(IncludeTool record);

    List<IncludeTool> selectByExample(IncludeToolExample example);

    IncludeTool selectByPrimaryKey(Integer includeToolId);

    int updateByExampleSelective(@Param("record") IncludeTool record, @Param("example") IncludeToolExample example);

    int updateByExample(@Param("record") IncludeTool record, @Param("example") IncludeToolExample example);

    int updateByPrimaryKeySelective(IncludeTool record);

    int updateByPrimaryKey(IncludeTool record);
}