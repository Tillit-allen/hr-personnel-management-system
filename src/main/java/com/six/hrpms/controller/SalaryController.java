package com.six.hrpms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.SalaryRecord;
import com.six.hrpms.pojo.User;
import com.six.hrpms.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: xkk
 * @Date: 2019/1/3 16:09
 */
@Controller
@RequestMapping("/salary/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("toSalaryList")
    public String toSalaryListWithCommon() {
        return "/salary/salaryList";
    }

        @RequestMapping("toSalaryListWithAdmin")
    public String toSalaryListWithAdmin(HttpSession session) {
        return "/salary/salaryListAdmin";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("getSalaryList")
    @ResponseBody
    public JSON getSalaryRecordList(HttpSession session, Integer pageNum, Integer pageSize, Date start, Date end){
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        User user = (User) session.getAttribute("user");
        SalaryRecord salaryRecord = new SalaryRecord();
//        salaryRecord.setUserId("111");
        salaryRecord.setUserId(user.getUserId());
        salaryRecord.setStartTime(start);
        salaryRecord.setEndTime(end);

        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("end_time desc");
        List<SalaryRecord> salaryList = salaryService.findSalaryList(salaryRecord, null, null);

        PageInfo<SalaryRecord> salaryRecordPageInfo = new PageInfo<>(salaryList,10);
        return JSON.ok(salaryRecordPageInfo);
    }

    @RequestMapping("toSalaryInfo")
    public String toSalaryInfo(Integer id,HttpSession session,Model model){

        SalaryRecord salaryRecordInfo = salaryService.findSalaryListById(id);
        model.addAttribute("salaryRecordInfo",salaryRecordInfo);
        return "/salary/salaryInfo";

    }

    /**
     * 查询列表(管理员接口)
     * @param session 权限验证
     * @param pageNum 页码
     * @param pageSize 每页显示个数
     * @param salaryRecord 查询用户信息(用户id,开始结束时间)
     * @param userName 用户名
     * @param bossName 老板名称
     * @return 查询结果
     */
    @RequestMapping("getSalaryListWithAdmin")
    @ResponseBody
    public JSON getSalaryRecordListWithAdmin(HttpSession session, Integer pageNum, Integer pageSize, SalaryRecord salaryRecord,String userName,String bossName){
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("end_time desc");
        List<SalaryRecord> salaryList = salaryService.findSalaryList(salaryRecord, userName, bossName);

        PageInfo<SalaryRecord> salaryRecordPageInfo = new PageInfo<>(salaryList,10);
        return JSON.ok(salaryRecordPageInfo);
    }


    /**
     * 发放奖金(系统中所有用户)
     * @param session 用户信息
     * @param bonus 奖金
     * @return 发放奖金数量及状态
     */
    @RequestMapping("salaryMoneyAllUserWithAdmin")
    @ResponseBody
    public JSON salaryMoneyAllUserWithAdmin(HttpSession session, Double bonus){

        Integer payoff = salaryService.payoff(bonus);

        return JSON.ok(payoff);
    }

    /**
     * 发放奖金(选中人员)
     * @param userIds 用户id列表
     * @param bonus 奖金
     * @param session 用户信息
     * @return 发放奖金数量及状态
     */
    @RequestMapping("salaryMoneyByUserIdsWithAdmin")
    @ResponseBody
    public JSON salaryMoneyByUserIdsWithAdmin(List<String> userIds,Double bonus,HttpSession session){
        Integer payoff = salaryService.payoff(userIds, bonus);
        return JSON.ok(payoff);
    }
}
