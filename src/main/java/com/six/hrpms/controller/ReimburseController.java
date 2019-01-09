package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.BusinessRecord;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserInfo;
import com.six.hrpms.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/BusinessRecord")
public class ReimburseController {
    @Autowired
    private ReimburseService reimburseService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/addBRecord")
    public String addBRecord(double a, double b, double c, double d, double e, String startTime, String endTime, String aim,
                             HttpSession session) throws ParseException {
        System.out.printf("======" + a + b + c + d + e);
        double sum = a + b + c + d + e;
        User user = (User) session.getAttribute("user");
        // 日期格式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sTime = simpleDateFormat.parse(startTime);
        Date eTime = simpleDateFormat.parse(endTime);

        BusinessRecord businessRecord = new BusinessRecord();
        businessRecord.setMoney(sum);
        businessRecord.setAim(aim);
        businessRecord.setAuditStatus(1);
        businessRecord.setUserId(user.getUserId());
        businessRecord.setStartTime(sTime);
        businessRecord.setEndTime(eTime);

        reimburseService.insertBRecord(businessRecord);


        return "redirect:/BusinessRecord/toUserRecordList";
    }

    /**
     * 查询个人的出差报销列表
     * @return
     */
    @RequestMapping("/toUserRecordList")
    public  String toUserRecordList(HttpSession session, Model model) {
        User user=(User) session.getAttribute("user");
        String id = user.getUserId();
        List<BusinessRecord> businessRecords = reimburseService.selectBRecordById(id);
        model.addAttribute("bRecords", businessRecords);
        return "Reimburse/userlist";
    }

    @RequestMapping("/deleteRecord")
    public void deleteRecord(Integer id) {
        reimburseService.deleteById(id);
    }
    /**查询管理员的出差报销列表
     * @return
     */
    @RequestMapping("/toAdminList")
    public  String toAdminList(HttpSession session, Model model) {
        User user=(User) session.getAttribute("user");
        String id = user.getUserId();
        List<BusinessRecord> businessRecords = reimburseService.selectBRecordById(id);
        model.addAttribute("bRecords", businessRecords);
        return "Reimburse/AdminList";
    }
    /**
     * 获取审核中的数据
     */
    @RequestMapping(value = "/getData")
    @ResponseBody
    public JSON getData(){
        return JSON.ok(reimburseService.selectAllData());
    }

    /*
     *   管理员校验添加员工是否通过
     * */
    @RequestMapping(value = "/adminCheck",method = {RequestMethod.POST})
    @ResponseBody
    public JSON checkEmployAdmin(HttpSession session, BusinessRecord businessRecord, String flag){
       if(flag.equals("true")){
        businessRecord.setAuditStatus(2);
       }else{
           businessRecord.setAuditStatus(3);
       }
        return JSON.ok(reimburseService.UpdateStatus(businessRecord));
    }
}
