package com.six.hrpms.service.impl;
import com.six.hrpms.dao.BusinessRecordMapper;
import com.six.hrpms.pojo.BusinessRecord;
import com.six.hrpms.pojo.BusinessRecordExample;
import com.six.hrpms.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReimburseServiceImpl implements ReimburseService {
    @Autowired
    private BusinessRecordMapper businessRecordMapper;


    @Override
    public void insertBRecord(BusinessRecord businessRecord) {
        businessRecordMapper.insertSelective(businessRecord);
    }

    @Override
    public List<BusinessRecord> selectBRecordById(String userId) {
        BusinessRecordExample businessRecordExample = new BusinessRecordExample();
        BusinessRecordExample.Criteria criteria = businessRecordExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<BusinessRecord> businessRecords = businessRecordMapper.selectByExample(businessRecordExample);
        return businessRecords;
    }

    @Override
    public int UpdateStatus(BusinessRecord businessRecord) {
        BusinessRecordExample example = new BusinessRecordExample();
        BusinessRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(businessRecord.getId());
        criteria.andUserIdEqualTo(businessRecord.getUserId());
        return businessRecordMapper.updateByExampleSelective(businessRecord,example);
    }

    @Override
    public List<BusinessRecord> selectAllData() {
        BusinessRecordExample example = new BusinessRecordExample();
        BusinessRecordExample.Criteria criteria = example.createCriteria();
        criteria.andAuditStatusEqualTo(1);
        return businessRecordMapper.selectByExample(example);
    }

    @Override
    public void deleteById(Integer id) {
        businessRecordMapper.deleteByPrimaryKey(id);
    }
}
