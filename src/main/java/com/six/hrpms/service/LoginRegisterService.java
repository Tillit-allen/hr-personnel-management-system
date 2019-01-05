//package com.six.hrpms.service;
//
//import com.six.hrpms.pojo.User;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public interface LoginRegisterService {
//
//    /*
//    *   注册发送验证码短信
//    *   @params:电话号码,验证码,request,response
//    *   @return:发送短信状态
//    * */
//    String sendMes(String phoneNum, String code, HttpServletRequest request, HttpServletResponse response);
//
//    /*
//    *   校验短信验证码
//    *   @params:用户手机号，用户输入的验证码，request
//    *   @return:校验结果,状态码
//    * */
//    String checkCode(String phoneNum, String code, HttpServletRequest request);
//
//    /*
//    *   执行注册动作&&向人事表插入新数据
//    *   @mark:用户自己注册的时候填表单，那个信息插入到人事表里，不是管理员校验补全的
//    *   @params:
//    *   @return:插入数据库影响的记录条数
//    * */
//    int doRegist(User user);
//
//
//    /*
//    *   登陆校验：从user表里看看账号密码对不对
//    *   @params：登陆信息的User对象
//    *   @return：登陆信息的User对象
//    */
//    User doLogin(User user);
//}
