//package com.six.hrpms.service.impl;
//
//import com.six.hrpms.dao.UserMapper;
//import com.six.hrpms.pojo.User;
//import com.six.hrpms.pojo.UserExample;
//import com.six.hrpms.service.LoginRegisterService;
////import com.zhenzi.sms.ZhenziSmsClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Service
//public class LoginRegistService_impl implements LoginRegisterService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public String sendMes(String phoneNum, String code, HttpServletRequest request, HttpServletResponse response) {
//
//        String res = null;
//        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "100397",
//                "ZmQxZWVkNjYtYWIwMC00YTRjLThiNTUtY2EwYzUyYjE0ODI2");
//        try {
//            res = client.send(phoneNum, "您的验证码为"+code+",欢迎使用本系统！")+client.balance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Cookie cookie = new Cookie(phoneNum,code);//把随机数存到cookie里并规定时间只有5分钟
//        cookie.setMaxAge(300);
////        cookie.setPath(request.getContextPath());//设置cookie的路径
//        response.addCookie(cookie);//把cookie放到response域里面
//        return res;
//    }
//
//    @Override
//    public int doRegist(User user) {
//        return userMapper.insert(user);
//    }
//
//    @Override
//    public User doLogin(User user) {
//        UserExample example = new UserExample();
//        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andLoginNameEqualTo(user.getLoginName());
//        criteria.andPasswordEqualTo(user.getPassword());
//        List<User> u = userMapper.selectByExample(example);
////        System.out.println("====================================size"+u.size());
//        if(u.size()!=0) {
//                return u.get(0);
//        }
//
//        return null;
//    }
//
//    @Override
//    public String checkCode(String phoneNum, String code, HttpServletRequest request) {
//        Cookie cookie[] = request.getCookies();
//        String res = null;
//        for (Cookie cookie1 : cookie) {
//            if (phoneNum.equals(cookie1.getName())) {
//                res = cookie1.getValue();
//                break;
//            }
//        }
//        if (!res.equals("") && res != null) {
//            if (res.equals(code)) {
//                return "200";
//            }
//        }
//        return "500";
//    }
//}
