package com.six.hrpms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.LeaveRecord;
import com.six.hrpms.pojo.User;

import com.six.hrpms.service.LeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveRecordController {
    private LeaveRecord leaveRecord;
    @Autowired
    private LeaveRecordService leaveRecordService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("toLeaveListWithAdmin")
    public String toLeaveListWithAdmin(HttpSession session) {
        return "leave/leaveListWithAdmin";
    }

    @RequestMapping("toAddLeaveList")
    public String toAddLeaveList(HttpSession session) {
        return "leave/addLeaveRecord";
    }

    @RequestMapping("toLeaveList")
    public String toLeaveList() {
        return "leave/leaveList";
    }

    @RequestMapping("toUpdateLeaveList")
    public String toUpdateLeaveList(Integer id,Model model) {
        model.addAttribute("LeaveRecordInfo",leaveRecordService.findLeaveRecordById(id));
        return "leave/updateLeaveRecord";
    }

    @RequestMapping("toCheckLeaveRecord")
        public String toCheckLeaveRecord(Integer id,Model model){
        model.addAttribute("LeaveRecordInfo",leaveRecordService.findLeaveRecordById(id));
        return "leave/CheckLeaveRecord";
    }

    //上司浏览请假信息
    @RequestMapping("/getLeaveListWithAdmin")
    @ResponseBody
    public JSON findAllListWithAdmin(Integer pageNum, Integer pageSize, Date start, Date end) {

        PageHelper.startPage(pageNum, pageSize);
        List<LeaveRecord> allList = leaveRecordService.findAllList(start, end);

        PageInfo<LeaveRecord> leaveRecordPageInfo = new PageInfo<>(allList);
        return JSON.ok(leaveRecordPageInfo);
    }

    //用户获取个人请假信息
    @RequestMapping("/getLeaveList")
    @ResponseBody
    public JSON findByUserId(HttpSession session, Integer pageNum, Integer pageSize, Date start, Date end) {

        User u = (User) session.getAttribute("user");

        PageHelper.startPage(pageNum, pageSize);
        List<LeaveRecord> leaveRecordList = leaveRecordService.findByUserId(u.getUserId(), start, end);

        PageInfo<LeaveRecord> leaveRecordPageInfo = new PageInfo<>(leaveRecordList);
        return JSON.ok(leaveRecordPageInfo);
    }

    @RequestMapping("toLeaveListById")
    public String toLeaveListById(Integer id, Model model){

        model.addAttribute("leaveRecord",leaveRecordService.findLeaveRecordById(id));
        return "/leave/leaveInfo";
    }

    //员工申请请假
    @RequestMapping("/addLeaveRecord")
    public String insertLeaveRecord(HttpSession session,LeaveRecord leaveRecord) {
        User u = (User) session.getAttribute("user");
        leaveRecord.setUserId(u.getUserId());
        leaveRecordService.insertLeaveRecord(leaveRecord);
        return "leave/leaveList";
    }

    //员工取消请假
    @RequestMapping("/deleteById")
    public String deleteById(LeaveRecord leaveRecord, RedirectAttributesModelMap model) {

        try {
            leaveRecordService.deleteById(leaveRecord);
            leaveRecordService.findByUserId(leaveRecord.getUserId(),null,null);
        } catch (Exception e) {
            if (e.getMessage().equals("删除失败")) {
                model.addFlashAttribute("exceptionMessage", "删除失败");
            }
        }
        return  "leave/leaveList";
    }

    //修改请假信息
    @RequestMapping("updateLeaveRecord")
    public String updateLeaveRecord(LeaveRecord leaveRecord, RedirectAttributesModelMap model) {

        try {
            leaveRecordService.updateLeaveRecord(leaveRecord);
        } catch (Exception e) {
            if (e.getMessage().equals("原因空")) {
                model.addFlashAttribute("exceptionMessage", "填写原因");

            } else if (e.getMessage().equals("开始时间空")) {
                model.addFlashAttribute("exceptionMessage", "填写开始时间");

            } else if (e.getMessage().equals("结束时间空")) {
                model.addFlashAttribute("exceptionMessage", "填写结束时间");

            } else if (e.getMessage().equals("更新数据异常")) {
                model.addFlashAttribute("exceptionMessage", "更新数据异常");

            }
        }
        return "/leave/leaveList";
    }

    //审核(admin)
    @RequestMapping("CheckLeaveRecord")
    public String CheckLeaveRecord(LeaveRecord leaveRecord, RedirectAttributesModelMap model) {

        try {
            leaveRecordService.CheckLeaveRecord(leaveRecord);
        } catch (Exception e) {

        }
        return "/leave/leaveListWithAdmin";
    }

}
