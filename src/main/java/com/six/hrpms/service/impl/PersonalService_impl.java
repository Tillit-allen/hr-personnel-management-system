package com.six.hrpms.service.impl;


import com.six.hrpms.dao.UserInfoMapper;
import com.six.hrpms.pojo.UserInfo;
import com.six.hrpms.pojo.UserInfoExample;
import com.six.hrpms.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService_impl implements PersonalService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAllUser() {
        UserInfoExample example =new UserInfoExample();//select * from user_info
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIsNotNull();
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public UserInfo selectFromUserInfo(UserInfo userInfo) {
        return userInfoMapper.selectByPrimaryKey(userInfo.getUserId());
}

    @Override
    public int addEmplForAdmin(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int addEmplForEmpl(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public int updateEmplForAdmin(UserInfo userInfo) {

//        return userInfoMapper.updateByExample(userInfo,);
        return 0;
    }
}
