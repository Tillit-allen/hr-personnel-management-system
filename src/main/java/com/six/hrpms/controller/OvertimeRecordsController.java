package com.six.hrpms.controller;

import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.OvertimeRecords;
import com.six.hrpms.pojo.OvertimeRecordsExample;
import com.six.hrpms.service.OvertimeRecordsService;
import com.six.hrpms.utils.DateAndStringTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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


    @Autowired
    private OvertimeRecordsService overtimeRecordsService;

    /**
     * 添加
     * ,method = {RequestMethod.POST}
     */
    @RequestMapping(value = "addOvertimeRecords")
    @ResponseBody
    public JSON addOvertimeRecords(OvertimeRecords overtimeRecords) {
        System.out.println("=============================" + overtimeRecords.getId());
        overtimeRecordsService.addOvertimeRecords(overtimeRecords);

        return JSON.ok();
    }

    /**
     * 员工信息删除
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
     * 修改
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
     * 员工信息显示
     */
    @RequestMapping(value = "getApplyOvertime")
    @ResponseBody
    public JSON getApplyOvertime() {
        return JSON.ok(overtimeRecordsService.getApplyOvertime());
    }

//    /**
//     * 员工信息修改
//     */
//    @RequestMapping(value = "getApplyOvertimeRecords1")
//    @ResponseBody
//    public JSON getApplyOvertimeRecords1(OvertimeRecords overtimeRecords){
//        overtimeRecordsService.getApplyOvertimeRecords1(overtimeRecords);
//        return JSON.ok();
//    }

    /**
     * 员工信息查询
     */
    @RequestMapping(value = "selectOvertimeRecords", method = {RequestMethod.POST})
    @ResponseBody
    public JSON selectOvertimeRecords(OvertimeRecords overtimeRecords) {
        overtimeRecordsService.selectOvertimeRecords(overtimeRecords);
        return JSON.ok();
    }

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
}


