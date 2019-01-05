package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.UserInfo;
import com.six.hrpms.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.six.hrpms.pojo.AddminAddEmployee_po;

@Controller
@RequestMapping(value = "/userInfo")
public class PersonalController {

//    @Autowired
    private UserInfo userInfo = new UserInfo();
    @Autowired
    private PersonalService personalService;

    /*
    *   显示员工列表
    *   @params：null
    *   @return：list<UserInfo>
    * */
    @RequestMapping(value = "/getAllEmployee",method = {RequestMethod.POST})
    @ResponseBody
    public JSON getAllEmployee(){
        return JSON.ok(personalService.getAllUser());
    }

    /*
    *    人事部门添加员工先填的那个表
    *     @params:表单内容
    *     @return:添加状态&&影响输入库记录条数
    * */
    @RequestMapping(value = "/addEmployee",method = {RequestMethod.POST})
    @ResponseBody
    public JSON addEmployeeForAdmin(AddminAddEmployee_po addminAddEmployee_po){
        userInfo.setUserName(addminAddEmployee_po.getName());
        userInfo.setSex((addminAddEmployee_po.getSex()));
        userInfo.setBasicSalary(addminAddEmployee_po.getBasemoney());
        userInfo.setUserId(addminAddEmployee_po.getId());
        userInfo.setBossName(addminAddEmployee_po.getBoss());
        userInfo.setIsAdministrator(0);
        int flag;
        if(personalService.selectFromUserInfo(userInfo)==null){//查看员工是否已经存在
            flag = personalService.addEmplForAdmin(userInfo);
        }else{
            return JSON.errorMsg("用户已存在！");
        }
        return JSON.ok(flag);
    }

    /*
    *   按照userId读从user_info表数据
    *   @params：传过来的当前登陆的员工信息
    *   return：读出来的数据
    * */
    @RequestMapping(value = "/getEmployeeData_",method = {RequestMethod.POST})
    @ResponseBody
    public JSON getEmployeeForEmployee(UserInfo userInfo){
        this.userInfo =  personalService.selectFromUserInfo(userInfo);
        return JSON.ok(this.userInfo);
    }

    /*
    *   把员工补全的信息更新到表里等待校验
    *   @params:表单信息
    *   @return：傻子都知道
    * */
    @RequestMapping(value = "/updateUserInfo_",method = {RequestMethod.POST})
    @ResponseBody
    public JSON  addEmployeeForEmployee(UserInfo userInfo){
        if(personalService.addEmplForEmpl(userInfo)>0){//这个方法名字叫add，其实里面是update方法
            return JSON.ok();
        }
        return JSON.errorMsg("更新失败！");
    }

    /*
    *   管理员校验添加员工是否通过
    * */
    @RequestMapping(value = "/adminCheck",method = {RequestMethod.POST})
    @ResponseBody
    public JSON checkEmploy(UserInfo userInfo){
        if(userInfo.getIsAdministrator()!=0){
            personalService.updateEmplForAdmin(userInfo);
        }
        return JSON.ok();
    }


    //管理员拉取待审核信息
    @RequestMapping(value = "/getCheck",method = {RequestMethod.POST})
    @ResponseBody
    public JSON getCheck(){

        return JSON.ok();
    }
}
