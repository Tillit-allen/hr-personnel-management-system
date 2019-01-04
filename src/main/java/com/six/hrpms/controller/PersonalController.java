package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserInfo;
import com.six.hrpms.service.PersonalService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.six.hrpms.pojo.AddminAddEmployee_po;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/userInfo")
public class PersonalController {
    private UserInfo userInfo = new UserInfo();
    private User user = new User();
    @Autowired
    private PersonalService personalService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


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

    //显示未激活的员工列表
    @RequestMapping(value = "/getUnActiveEmployee",method = {RequestMethod.POST})
    @ResponseBody
    public JSON getUnActiveEmployee(){
        return JSON.ok(personalService.getUnActiveEmpl());
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
        user.setLoginName(addminAddEmployee_po.getLoginName());
        user.setPassword(addminAddEmployee_po.getPassword());
        user.setUserId(addminAddEmployee_po.getId());
        int flag;
        if(personalService.selectFromUserInfo(userInfo)==null){//查看员工是否已经存在
            flag = personalService.addEmplForAdmin(userInfo);
            if(personalService.selectFromUser(user)==null){//同时user表中也新增信息
                personalService.addUserForAdmin(user);
            }
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
    @RequestMapping(value = "/getEmployeeDataForModify",method = {RequestMethod.POST})
    @ResponseBody
    public JSON getEmployeeForEmployee2(){
        return JSON.ok(personalService.selectFromUserInfo(userInfo));
    }

    /*
    *   把员工补全的信息更新到表里等待校验
    *   @params:表单信息
    *   @return：傻子都知道
    * */
    @RequestMapping(value = "/updateUserInfo_",method = {RequestMethod.POST})
    @ResponseBody
    public JSON  addEmployeeForEmployee(UserInfo userInfo){
        userInfo.setIsAdministrator(1);//设置当前用户状态为：等待管理员校验
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
    public JSON checkEmploy(UserInfo userInfo,String flag){
        if(flag.equals("true")){
            userInfo.setIsAdministrator(3);
        }else
        {
            userInfo.setIsAdministrator(2);
        }
            personalService.updateEmplForAdmin(userInfo);
        return JSON.ok();
    }

    //跳转至修改页面
    @RequestMapping(value = "/toChange")
    public String toChange(@Param("userId") String userId){
        userInfo.setUserId(userId);
        return "employee/ModifyEmployee";
    }
    //管理员编辑员工信息
    @RequestMapping(value = "/adminModify",method = {RequestMethod.POST})
    @ResponseBody
    public JSON adminModify(UserInfo userInfo){
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String date = format.format(userInfo.getBirthday());
//        userInfo.setBirthday(date);
       if(personalService.updateEmplForAdmin(userInfo)==1)
       {
           return JSON.ok();
       }
      return JSON.errorMsg("修改失败");
    }

    //管理员删除员工信息
    @RequestMapping(value = "/adminDelete",method = {RequestMethod.POST})
    @ResponseBody
    public JSON adminDelete(UserInfo userInfo){
        if(personalService.deleteEmplForAdmin(userInfo)==1){
            return JSON.ok();
        }
        return JSON.errorMsg("删除失败！");

    }

    //管理员查询员工信息
    @RequestMapping(value = "/adminSearch",method = {RequestMethod.POST})
    @ResponseBody
    public JSON adminSearch(UserInfo userInfo,String flag){
        System.out.println(userInfo.getUserId());
        System.out.println(userInfo.getUserName());
        List<UserInfo> list = personalService.searchEmplForAdmin(userInfo,flag);
        return JSON.ok(list);
    }
}
