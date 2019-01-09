package com.six.hrpms.service.impl;

import com.six.hrpms.dao.UserMapper;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserExample;
import com.six.hrpms.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoginRegistService_impl implements LoginRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User doLogin(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(user.getLoginName());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> u = userMapper.selectByExample(example);
        if(u.size()!=0) {
                return u.get(0);
        }

        return null;
    }

    @Override
    public String checkCode(String phoneNum, String code, HttpServletRequest request) {
        Cookie cookie[] = request.getCookies();
        String res = null;
        for (Cookie cookie1 : cookie) {
            if (phoneNum.equals(cookie1.getName())) {
                res = cookie1.getValue();
                break;
            }
        }
        if (!res.equals("") && res != null) {
            if (res.equals(code)) {
                return "200";
            }
        }
        return "500";
    }
}
