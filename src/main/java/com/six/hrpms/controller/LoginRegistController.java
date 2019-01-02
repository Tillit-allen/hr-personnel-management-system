package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.common.randomNum;
import com.six.hrpms.pojo.User;
import com.six.hrpms.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.Login_po;
import po.Regist_po;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginRegistController {

    @Autowired
    private LoginRegisterService loginRegisterService;
//    @Autowired
    private User user = new User();

    //登陆注册用的页面跳转
    @RequestMapping(value = "/toLoRePage")
    public String toPage(String page){
        System.out.println("123123123123"+page);
        return page;
    }

    //发送短信验证码
    @RequestMapping(value = "/send",method = {RequestMethod.POST})
    @ResponseBody
    public JSON send(Regist_po regist_po, HttpServletRequest request, HttpServletResponse response, Model model){
        String randomnumber =  randomNum.getRandomNum();//产生6位随机数
        String res = loginRegisterService.sendMes(regist_po.getPhone(),randomnumber,request,response);//发就完事了
        model.addAttribute("asdasda","");
        return JSON.ok(res);
    }

    //发出账号激活申请
    @RequestMapping(value = "/regist",method = {RequestMethod.POST})
    @ResponseBody
    public JSON regist(Regist_po regist_po, String code, HttpServletRequest request){
        String status = loginRegisterService.checkCode(regist_po.getPhone(),code,request);
        if(status == "200"){
            loginRegisterService.doRegist(user);//发出账号申请
            return JSON.ok();
        }else {
            return JSON.errorMsg("验证码错误");
        }
    }

    //用户登陆
    @RequestMapping(value = "/login.do",method = {RequestMethod.POST})
    public ModelAndView login(Login_po login_po){
        user.setLoginName(login_po.getLoginName());
        user.setPassword(login_po.getPassword());
        loginRegisterService.doLogin(user);
        return new ModelAndView();
    }
}
