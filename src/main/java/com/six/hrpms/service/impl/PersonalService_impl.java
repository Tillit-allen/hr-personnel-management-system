package com.six.hrpms.service.impl;


import com.six.hrpms.dao.UserInfoMapper;
import com.six.hrpms.dao.UserMapper;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserExample;
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
    @Autowired
    private UserMapper userMapper;
    private User user = new User();
    @Override
    public List<UserInfo> getAllUser() {
        UserInfoExample example =new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIsNotNull();//select * from user_info
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public User selectFromUser(User user) {
        return userMapper.selectByPrimaryKey(user.getUserId());
    }

    @Override
    public UserInfo selectFromUserInfo(UserInfo userInfo) {
        return userInfoMapper.selectByPrimaryKey(userInfo.getUserId());
}

    @Override
    public int addUserForAdmin(User user) {
        return userMapper.insertSelective(user);
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
    public int deleteEmplForAdmin(UserInfo userInfo) {
                userMapper.deleteByPrimaryKey(userInfo.getUserId());
        return userInfoMapper.deleteByPrimaryKey(userInfo.getUserId());
    }

    @Override
    public int updatePassWord(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
//        criteria.andPasswordEqualTo(user.getPassword());
        return userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public List<User> checkPassWord(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andUserIdEqualTo(user.getUserId());
        return userMapper.selectByExample(example);
    }

    @Override
    public List<UserInfo> searchEmplForAdmin(UserInfo userInfo,String flag) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();

        if(flag.equals("1")){//1是按工号查询
            System.out.println("进入到了工号查询了");
            criteria.andUserIdLike(userInfo.getUserId()+"%");
//            criteria.andUserIdLike

        }else{
            System.out.println("进入到了姓名查询了");
            criteria.andUserNameLike(userInfo.getUserName()+"%");

        }
        List<UserInfo> list =  userInfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<UserInfo> getUnActiveEmpl() {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsAdministratorEqualTo(1);
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public int updateEmplForAdmin(UserInfo userInfo) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userInfo.getUserId());
        return userInfoMapper.updateByExampleSelective(userInfo,example);
    }
}
