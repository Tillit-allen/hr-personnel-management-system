//package com.six.hrpms.controller;
//
//import com.six.hrpms.pojo.OvertimeRecords;
//import com.six.hrpms.service.OvertimeRecordsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping(value="/overTime")
//public class OvertimeRecordsController {
//
//    @Autowired
//    private OvertimeRecordsService overtimeRecordsService;
//
//    /**
//     * 添加
//     */
//    @RequestMapping(value="/addOvertimeRecords",method = {RequestMethod.POST})
//    public String addOvertimeRecords(Model model, OvertimeRecords overtimeRecords){
////        System.out.println("============================="+overtimeRecords.getId());
//        overtimeRecordsService.addOvertimeRecords(overtimeRecords);
//        return "OvertimeRecords/showApplyOvertime";
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping(value="deleteOvertimeRecords")
//    public String deleteOvertimeRecords(Model model, OvertimeRecords overtimeRecords){
//        overtimeRecordsService.deleteOvertimeRecords(overtimeRecords);
//        return "OvertimeRecords/showApplyOvertime";
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping(value="updateOvertimeRecords")
//    public String updateOvertimeRecords(Model model, OvertimeRecords overtimeRecords) {
//        overtimeRecordsService.updateOvertimeRecords(overtimeRecords);
//        return "OvertimeRecords/showApplyOvertime";
//    }
//
//    /**
//     * 查询
//     */
//    @RequestMapping(value="selectOvertimeRecords")
//    public String selectOvertimeRecords(Model model, OvertimeRecords overtimeRecords) {
//        overtimeRecordsService.selectOvertimeRecords(overtimeRecords);
//        return "OvertimeRecords/showApplyOvertime";
//    }
//
//}
//
