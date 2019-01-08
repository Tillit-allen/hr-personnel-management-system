package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.dao.UserInfoMapper;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserInfo;
import com.six.hrpms.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.six.hrpms.pojo.Login_po;
import javax.servlet.http.HttpSession;

@Controller
public class LoginRegistController {

    @Autowired
    private LoginRegisterService loginRegisterService;
    @Autowired
    private UserInfoMapper userInfoMapper;
    private User user = new User();
    private UserInfo userInfo = new UserInfo();
    //用户登陆
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public JSON login(Login_po login_po, HttpSession session){
        user.setLoginName(login_po.getLoginName());
        user.setPassword(login_po.getPassword());
        User u = loginRegisterService.doLogin(user);
        if(u!=null){
                userInfo = userInfoMapper.selectByPrimaryKey(u.getUserId());
                session.setMaxInactiveInterval(30*60);
                session.setAttribute("user",userInfo);
                session.setAttribute("sessionid",session.getId());
            return JSON.ok();
        }else {
            return JSON.errorMsg("用户名或密码错误！");
        }
    }

    //用户登出
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/main";
    }
}

