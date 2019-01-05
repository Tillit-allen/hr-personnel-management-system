package com.six.hrpms.controller;

import com.six.hrpms.pojo.LeaveRecord;
import com.six.hrpms.service.LeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
@Controller
@RequestMapping("/")
public class LeaveRecordController {
    @Autowired
    private LeaveRecordService leaveRecordService;

    //浏览
    @RequestMapping("findAllList.action")
    public String findAllList(Model model){
        //将收录工具集合传到前台
        model.addAttribute("findAllList",leaveRecordService.findAllList());
        return "/leave/leave";
    }

    //userid查询
    @RequestMapping("findByuserId.action")
    public String findByuserId(LeaveRecord leaveRecord,Model model){
        model.addAttribute("findByuserIdList",leaveRecordService.findByuserId(leaveRecord));
        return "/leave/leave";
    }

    //申请请假
    @RequestMapping("insertLeaveRecord.action")
    public String insertLeaveRecord(LeaveRecord leaveRecord, RedirectAttributesModelMap model){
        try {
            leaveRecordService.insertLeaveRecord(leaveRecord);
        } catch (Exception e) {
            //异常处理，返回更新数据失败信息
            if (e.getMessage().equals("原因不能空")) {
                model.addFlashAttribute("exceptionMessage","请填写请假原因");
                return "redirect:showAddRecordList.action";
            }else if (e.getMessage().equals("请假时间不能空")){
                model.addFlashAttribute("exceptionMessage","请填写请假时间");
                return "redirect:showAddRecordList.action";
            }
        }
        return "redirect:leave/leave";
    }

    //取消申请
    @RequestMapping("deleteById.action")
        public String deleteById(LeaveRecord leaveRecord, RedirectAttributesModelMap model){

        try{
             leaveRecordService.deleteById(leaveRecord);
        }catch (Exception e) {
            if (e.getMessage().equals("删除失败")) {
                model.addFlashAttribute("exceptionMessage", "删除失败");

            }
        }
        return "redirect:/leave/leave" ;
    }

    //修改
    @RequestMapping("UpdateLeaveRecord.action")
        public String UpdateLeaveRecord(LeaveRecord leaveRecord,RedirectAttributesModelMap model){

        try{
            leaveRecordService.updateLeaveRecord(leaveRecord);
        }catch(Exception e){
            if(e.getMessage().equals("原因空")){
                model.addFlashAttribute("exceptionMessage", "填写原因");
            }else if(e.getMessage().equals("开始时间空")){
                model.addFlashAttribute("exceptionMessage","填写开始时间");
            }else if(e.getMessage().equals("结束时间空")){
                model.addFlashAttribute("exceptionMessage","填写结束时间");
            }else if(e.getMessage().equals("更新数据异常")){
                model.addFlashAttribute("exceptionMessage","更新数据异常");
            }
        }
        return "redirect:/leave/leave";
    }

    //审核
    @RequestMapping("CheckLeaveRecord.action")
        public String CheckLeaveRecord(LeaveRecord leaveRecord,RedirectAttributesModelMap model){

        try{
            leaveRecordService.CheckLeaveRecord(leaveRecord);
        }catch(Exception e){

        }
        return  "redirect:/leave/leave";
    }

}
