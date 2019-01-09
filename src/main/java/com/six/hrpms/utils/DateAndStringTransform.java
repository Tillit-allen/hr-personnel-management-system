package com.six.hrpms.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Date和string相互转化和计算差值
 *
 * @author: xkk
 * @Date: 2019/1/1 20:36
 */
public class DateAndStringTransform {

    /**
     * 一分钟转化的毫秒数
     */
    private static final long nm = 1000 * 60;

    /**
     * 一小时转化的毫秒数
     */
    private static final long nh = nm * 60;

    /**
     * 一天转化的毫秒数
     */
    private static final long nd = nh * 24;

    /**
     * 将日期转化为 yyyy-MM-dd 格式的字符串
     *
     * @param date 日期
     * @return 成功:转化后的字符串
     * 失败:null (date为null)
     */
    public static String format(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }

    /**
     * 将日期转化为 format 格式的字符串
     *
     * @param date 日期
     * @param format 日期格式
     * @return 成功:转化后的字符串
     * 失败:null (date为null)
     */
    public static String format(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        String dateStr = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            dateStr = simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
        return dateStr;
    }

    /**
     * 根据yyyy-MM-dd HH:mm:ss格式使用dateStr创建一个Date.
     * @param dateStr 日期
     * @return 创建出来的日期
     */
    public static Date parse(String dateStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据parse格式使用dateStr创建一个Date.
     * @param dateStr 日期
     * @param parse 日期格式
     * @return 创建出来的日期
     */
    public static Date parse(String dateStr,String parse){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个时间的分钟差
     *
     * @return
     */
    public static Long calculateTheTimeDifferenceAndMinute(Date start, Date end) {

        //参数合理性判断开始
        if (start == null || end == null) {
            return null;
        }
        if (start.after(end)) {
            new RuntimeException("时间出错,开始时间晚于结束时间");
        }
        //参数合理性判断结束

        long difference = end.getTime() - start.getTime();

        return difference / nm;
    }

    /**
     * 计算两个时间的小时差a
     *
     * @return
     */
    public static Long calculateTheTimeDifferenceAndHour(Date start, Date end) {

        //参数合理性判断开始
        if (start == null || end == null) {
            return null;
        }
        if (start.after(end)) {
            new RuntimeException("时间出错,开始时间晚于结束时间");
        }
        //参数合理性判断结束

        long difference = end.getTime() - start.getTime();

        return difference / nh;
    }

    /**
     * 判断时间是否在某个时间段之间
     *
     * @param when  被判断的时间
     * @param start 开始时间,格式(\d{2}:\d{2}),例如: "6:00"
     * @param end   结束时间,格式(\d{2}:\d{2}),例如: "19:00"
     * @return 成功:
     *              1:早于start
     *              2:在start和end之间
     *              3:晚于end
     *         失败:
     *              -1:start 晚于 end
     *              null: 参数为空
     * @throws RuntimeException start或end格式不正确
     */
    public static Integer judgmentPeriod(Date when, String start, String end) {

        //参数合理性判断开始
        if (when == null || start == null || end == null) {
            return null;
        }
        String regex = "\\d{2}:\\d{2}";
        if (!Pattern.matches(regex, start) || !Pattern.matches(regex, end)) {
            //start和end格式不正确
            new RuntimeException("时间段格式不正确!!!,start=" + start + "\tend=" + end);
        }
        //参数合理性判断结束
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        Date whenDate = null;
        Date startDate = null;
        Date endDate = null;
        try {
            when = simpleDateFormat.parse(simpleDateFormat.format(when));
            startDate = simpleDateFormat.parse(start);
            endDate = simpleDateFormat.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return belongCalender(when,startDate,endDate);

    }

    /**
     * 判断when是否在start和end之间
     *
     * @param when  被判断的时间
     * @param start 开始时间
     * @param end   结束时间
     * @return 成功:
     *              1:早于start
     *              2:在start和end之间
     *              3:晚于end
     *         失败:
     *              -1:start 晚于 end
     *              null: 参数为空
     */
    public static Integer belongCalender(Date when, Date start, Date end){

        Calendar date = Calendar.getInstance();
        date.setTime(when);
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);

        if (startDate.after(endDate)){
            return -1;
        }

        if (date.before(startDate)){
            return 1;
        }else if (date.before(endDate)){
            return 2;
        }else{
            return 3;
        }
    }

    /**
     * 获取date的前一天凌晨4点
     * @param date 时间
     * @return 改变后的时间
     */
    public static Date getLastDay4Points(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        return parse(format(calendar.getTime())+" 04:00:00");
    }

    /**
     * 获取date的后一天凌晨4点
     * @param date 时间
     * @return 改变后的时间
     */
    public static Date getNextDay4Points(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);
        return parse(format(calendar.getTime())+" 04:00:00");
    }





    @Test
    public void Test(){


        System.out.println(getLastDay4Points(new Date()).toLocaleString());

    }

}
