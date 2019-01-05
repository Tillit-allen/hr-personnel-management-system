//package com.six.hrpms.controller;
//
//import com.six.hrpms.common.JSON;
//import com.six.hrpms.common.randomNum;
//import com.six.hrpms.pojo.User;
//import com.six.hrpms.pojo.UserInfo;
//import com.six.hrpms.service.LoginRegisterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.six.hrpms.pojo.Login_po;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//
//import javax.jms.Session;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class LoginRegistController {
//
//    @Autowired
//    private LoginRegisterService loginRegisterService;
//    private User user = new User();
//
////    //发送短信验证码
////    @RequestMapping(value = "/send",method = {RequestMethod.POST})
////    @ResponseBody
////    public JSON send(UserInfo regist_po, HttpServletRequest request, HttpServletResponse response){
////        String randomnumber =  randomNum.getRandomNum();//产生6位随机数
////        String res = loginRegisterService.sendMes(regist_po.getPhone(),randomnumber,request,response);//发就完事了
////        return JSON.ok(res);
////    }
//
//    //信息存到userinfo表 等待管理员校验
//    @RequestMapping(value = "/register.action",method = {RequestMethod.POST})
//    @ResponseBody
//    public JSON register(UserInfo register_po, String code){
////        String status = loginRegisterService.checkCode(register_po.getPhone(),code,request);
////        if(status == "200"){
//            loginRegisterService.doRegist(user);//同步到user表
//            return JSON.ok();
////        }else {
////            return JSON.errorMsg("验证码错误");
////        }
//    }
//
//    //用户登陆
//    @RequestMapping(value = "/login",method = {RequestMethod.POST})
//    @ResponseBody
//    public JSON login(Login_po login_po, HttpSession session){
//        user.setLoginName(login_po.getLoginName());
//        user.setPassword(login_po.getPassword());
//        User u = loginRegisterService.doLogin(user);
//        if(u!=null){
////                model.addAttribute("user",u);
//                session.setAttribute("user",u);
//                session.setAttribute("sessionid",session.getId());
//            return JSON.ok();
//        }else {
//            return JSON.errorMsg("用户名或密码错误！"+session.getId());
//        }
//    }
//
//    //用户登出
//    @RequestMapping(value = "/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "/main";
//    }
//}
//
