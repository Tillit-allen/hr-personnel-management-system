package com.six.hrpms.service;


import com.six.hrpms.pojo.BusinessRecord;

import java.util.List;

public interface ReimburseService {
    void  insertBRecord(BusinessRecord businessRecord);

    /**
     * 通过用户id查询用户的费用清单
     * @param userId
     * @return
     */
    List<BusinessRecord> selectBRecordById(String userId);

    void deleteById(Integer id);
    //获取所有待审核的信息
    List<BusinessRecord> selectAllData();
    //审核动作
    int UpdateStatus(BusinessRecord businessRecord);
}
