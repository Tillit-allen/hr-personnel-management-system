package com.six.hrpms.service;

import com.six.hrpms.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginRegisterService {
    /*
    *   校验短信验证码
    *   @params:用户手机号，用户输入的验证码，request
    *   @return:校验结果,状态码
    * */
    String checkCode(String phoneNum, String code, HttpServletRequest request);


    /*
    *   登陆校验：从user表里看看账号密码对不对
    *   @params：登陆信息的User对象
    *   @return：登陆信息的User对象
    */
    User doLogin(User user);
}
