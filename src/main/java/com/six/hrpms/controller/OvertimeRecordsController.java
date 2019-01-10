package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.OvertimeRecords;
import com.six.hrpms.pojo.User;
import com.six.hrpms.service.OvertimeRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/")
public class OvertimeRecordsController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private OvertimeRecords overtimeRecords = new OvertimeRecords();
    @Autowired
    private OvertimeRecordsService overtimeRecordsService;

    /**
     * 添加
     * ,method = {RequestMethod.POST}
     */
    @RequestMapping(value = "addOvertimeRecords")
    @ResponseBody
    public JSON addOvertimeRecords(OvertimeRecords overtimeRecords) {

        overtimeRecordsService.addOvertimeRecords(overtimeRecords);

        return JSON.ok();
    }



    /**
     * 删除加班信息
     */
    @RequestMapping(value = "deleteOvertimeRecords")
    @ResponseBody
    public JSON deleteOvertimeRecords(OvertimeRecords overtimeRecords) {
        if (overtimeRecordsService.deleteOvertimeRecords(overtimeRecords) == 1) {
//
            return JSON.ok();
        }
        return JSON.errorMsg("删除失败！");

    }

    /**
     * 更新加班信息
     */
    @RequestMapping(value = "updateOvertimeRecords")
    public String updateOvertimeRecords(OvertimeRecords overtimeRecords) {
        overtimeRecordsService.updateOvertimeRecords(overtimeRecords);
        return "OvertimeRecords/showApplyOvertime";
    }

    /**
     *管理员 员工信息显示
     */
    @RequestMapping(value = "getApplyOvertimeRecords")
    @ResponseBody
    public JSON getApplyOvertimeRecords() {

        return JSON.ok(overtimeRecordsService.getApplyOvertimeRecords());
    }


    /**
     * 当前登录员工信息显示
     */
    @RequestMapping(value = "getApplyOvertime")
    @ResponseBody
    public JSON getApplyOvertime(HttpSession session) {
//        List<OvertimeRecords> overtimeRecords =
//        List<OvertimeRecordAdd> overtimeRecordAddList = new ArrayList<>();
//        for (OvertimeRecords orecords : overtimeRecords){
//            if (orecords.getAuditStatus() == 1){
//                OvertimeRecordAdd overtimeRecordAdd = new OvertimeRecordAdd();
//                overtimeRecordAdd.setAuditStatusName("通过");
//                overtimeRecordAdd.setId(orecords.getId());
//                overtimeRecordAdd.setUserId(orecords.getUserId());
//                overtimeRecordAdd.setStartTime(orecords.getStartTime());
//                overtimeRecordAdd.setEndTime(orecords.getEndTime());
//                overtimeRecordAdd.setPlace(orecords.getPlace());
//                overtimeRecordAddList.add(overtimeRecordAdd);
//
//            }
//
//        }


        return JSON.ok(overtimeRecordsService.getApplyOvertime(((User)session.getAttribute("user")).getUserId()));
    }



    /**
     * 员工信息查询
     */
    @RequestMapping(value = "selectOvertimeRecords")
//    @ResponseBody
    public String selectOvertimeRecords(Model model,String forSearch) {
        List<OvertimeRecords> overtimeRecords = overtimeRecordsService.selectOvertimeRecordsByuserId(forSearch);
        model.addAttribute("overtimeRecords",overtimeRecords);
        return "OvertimeRecords/checkAddApplyOvertime";
    }


    /**
     * 管理员审核
     * @param overtimeRecords
     * @return
     */
    @RequestMapping(value = "checkOverTime_Pass", method = {RequestMethod.POST})
    @ResponseBody
    public JSON checkOvertime(OvertimeRecords overtimeRecords) {
        overtimeRecords.setAuditStatus(1);
        if (overtimeRecordsService.checkOvertime(overtimeRecords) > 0) {
            return JSON.ok();
        } else {
            return JSON.errorMsg("核验失败");
        }

    }
    @RequestMapping(value = "checkOverTime_Reful", method = {RequestMethod.POST})
    @ResponseBody
    public JSON checkOvertime_jujue(OvertimeRecords overtimeRecords) {
        overtimeRecords.setAuditStatus(2);
        if (overtimeRecordsService.checkOvertime(overtimeRecords) > 0) {
            return JSON.ok();
        } else {
            return JSON.errorMsg("核验失败");
        }

    }


    /**
    编辑申请的编号
     */
    @RequestMapping(value = "toEditOvertime")
    public String toEdit(String id){
        int id_ = Integer.valueOf(id);
        overtimeRecords.setId(id_);
        return "OvertimeRecords/updateApplyOvertime";
    }

    @RequestMapping(value = "toSerachOvertime", method = {RequestMethod.POST})
    @ResponseBody
    public JSON toSerachOvertime(){
        OvertimeRecords overtimeRecords1 = overtimeRecordsService.selectOvertime(overtimeRecords);
        if(overtimeRecords1!=null){
            return JSON.ok(overtimeRecords1);
        }
        return JSON.errorMsg("查无此条纪录");
    }


}


