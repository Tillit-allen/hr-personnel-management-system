package com.six.hrpms.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.hrpms.common.JSON;
import com.six.hrpms.pojo.AttendanceRecord;
import com.six.hrpms.pojo.User;
import com.six.hrpms.service.AttendanceRecordService;
import com.six.hrpms.utils.DateAndStringTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Controller
public class AttendanceRecordController {
    @Autowired
    private AttendanceRecordService attendanceRecordService;
    /**************************用户功能***************************/

    /**
     * 跳转到签到列表页面
     *
     * @return
     */
    @RequestMapping(value = "/selectAttendanceRecord")
    public String selectOneAttendanceRecord(HttpSession session) {
        return "attendance/AttendanceRecordList";
    }

    /**
     * 获取签到列表
     *
     * @param session
     * @return
     */
    @RequestMapping("/getAttendanceRecordList")
    @ResponseBody
    public JSON getAttendanceRecordList(HttpSession session, Integer pageNum, Integer pageSize) {
        User u = (User) session.getAttribute("user");
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setUserId(u.getUserId()); //测试，将user_id设置为1

        PageHelper.startPage(pageNum, pageSize);
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.selectAttendanceRecordList(attendanceRecord);

        PageInfo<AttendanceRecord> attendanceRecordPageInfo = new PageInfo<>(attendanceRecordList);

        return JSON.ok(attendanceRecordPageInfo);
    }

    @RequestMapping("/getAttendanceRecordListWithAdmin")
    @ResponseBody
    public JSON getAttendanceRecordListWithAdmin(HttpSession session,AttendanceRecord attendanceRecord,
                                                  java.sql.Date datetime, Integer pageNum, Integer pageSize) {

        Date datetime1 = new Date();
        datetime1 = datetime;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(datetime1);
        calendar.add(calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
        datetime1 = calendar.getTime(); //这个时间就是日期往后推一天的结果
        java.sql.Date datetime2 = new java.sql.Date(datetime1.getTime());//获取往后推一天的时间
        User u = (User) session.getAttribute("user");
        attendanceRecord.setUserId(u.getUserId());

        PageHelper.startPage(pageNum, pageSize);
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime, datetime2);

        PageInfo<AttendanceRecord> attendanceRecordPageInfo = new PageInfo<>(attendanceRecordList);

        return JSON.ok(attendanceRecordPageInfo);
    }

    /**
     * 获取用户的签到状态
     *
     * @param model
     * @param attendanceRecord
     * @param session
     * @return
     */
    @RequestMapping(value = "/getStatus")
    public String getStatus(HttpSession session,Model model, AttendanceRecord attendanceRecord) {
        User u = (User) session.getAttribute("user");
        attendanceRecord.setUserId(u.getUserId());
        Date now1 = new Date();//获取现在时间
        java.sql.Date datetime1 = new java.sql.Date(now1.getTime());//将现在时间转为sql类型
        //将now1加上一天
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now1);
        calendar.add(calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
        now1 = calendar.getTime(); //这个时间就是日期往后推一天的结果
        java.sql.Date datetime2 = new java.sql.Date(now1.getTime());//将往后推一天的时间转为sql类型

        if (attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime1, datetime2).size() == 1) {
            model.addAttribute("attendanceRecordList0",
                    attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime1, datetime2).get(0).getStatus());
        } else if (attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime1, datetime2).size() == 2) {
            model.addAttribute("attendanceRecordList0",
                    attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime1, datetime2).get(1).getStatus());
        } else if (attendanceRecordService.selectAttendanceRecordList1(attendanceRecord, datetime1, datetime2).size() == 0) {
            model.addAttribute("attendanceRecordList0", 0);
        }
        return "attendance/Status";
    }

    /**
     * 签到
     *
     * @param attendanceRecord
     */
    @RequestMapping(value = "/insertAttendanceRecord1")
    public String insertAttendanceRecord1(HttpSession session,Model model, AttendanceRecord attendanceRecord) {
        User u = (User) session.getAttribute("user");//获取用户信息
        attendanceRecord.setUserId(u.getUserId());
        Integer time;   // 判断是否迟到
        /******判断当天是否已签到******/
        int number;//记录签到和签退,1为已经签到，2为已经签退
        Date date = new Date();
        //将date类型改为数据库的date类型
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate = java.sql.Date.valueOf(localDate);
        //获取数据库中的时间
        number = attendanceRecordService.selectTime(attendanceRecord, newDate);
        if (number == 0) {
            //当天未签到
            model.addAttribute("number", 0);//返回前端签到状态
            //随机生成id
            String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                int k = random.nextInt(base.length() - 1);
                sb.append(base.charAt(k));
            }
            attendanceRecord.setId(sb.toString());
            DateAndStringTransform dateAndStringTransform = new DateAndStringTransform(); //时间判断类
            //签到是否迟到判断
            time = dateAndStringTransform.judgmentPeriod(date, "09:00", "09:15");
            if (time == 1 || time == 2 || time == 3) {
                model.addAttribute("time", time);//返回前端迟到信息
                attendanceRecord.setStatus(time.toString());
                try {
                    attendanceRecordService.insertAttendanceRecord(attendanceRecord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("签到出错！");
            }
        } else if (number == 1) {
            //当天已经签到
            model.addAttribute("number", 1);//返回前端已经签到信息
            DateAndStringTransform dateAndStringTransform = new DateAndStringTransform(); //时间判断类
            time = dateAndStringTransform.judgmentPeriod(date, "18:00", "18:00");
            if (time == 1) {
                //未到签退时间
                model.addAttribute("time", 1);//返回前端未到签退时间信息
            } else if (time == 3) {
                //可以签退
                model.addAttribute("time", 3);//返回前端可以签退信息
                //随机生成id
                String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                Random random = new Random();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 3; i++) {
                    int k = random.nextInt(base.length() - 1);
                    sb.append(base.charAt(k));
                }
                attendanceRecord.setId(sb.toString());
                try {
                    attendanceRecord.setStatus("4");
                    attendanceRecordService.insertAttendanceRecord(attendanceRecord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //time值出错
                System.err.println("出现错误！");
            }
        } else if (number == 2) {
            //当天已经签退
            model.addAttribute("number", 2);
        } else {
            System.err.println("出现错误！");
        }
        return "attendance/Result";
    }
/**************************************管理员功能***********************************************************/
    /**
     * 跳转到签到列表页面
     *
     * @return
     */
    @RequestMapping(value = "/getAllAttendanceRecordList")
    public String selectAllAttendanceRecordWithAdmin(HttpSession session) {
        return "attendance/AttendanceRecordList1";
    }
    /**
     * 获取签到列表
     *
     * @param session
     * @return
     */
    @RequestMapping("/getAllAttendanceRecordList1")
    @ResponseBody
    public JSON getAllAttendanceRecordListWithAdmin(HttpSession session, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.findAllAttendanceRecordList();

        PageInfo<AttendanceRecord> attendanceRecordPageInfo = new PageInfo<>(attendanceRecordList);

        return JSON.ok(attendanceRecordPageInfo);
    }

    @RequestMapping("/getAllAttendanceRecordList2")
    @ResponseBody
    public JSON getAllAttendanceRecordList1WithAdmin(HttpSession session, java.sql.Date datetime, String userId, Integer pageNum, Integer pageSize) {

        Date datetime1 = new Date();
        datetime1 = datetime;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(datetime1);
        calendar.add(calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
        datetime1 = calendar.getTime(); //这个时间就是日期往后推一天的结果
        java.sql.Date datetime2 = new java.sql.Date(datetime1.getTime());//获取往后推一天的时间

        PageHelper.startPage(pageNum, pageSize);

        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.getUserAttendanceRecord(userId,datetime,datetime2);

        PageInfo<AttendanceRecord> attendanceRecordPageInfo = new PageInfo<>(attendanceRecordList);

        return JSON.ok(attendanceRecordPageInfo);
    }

}
