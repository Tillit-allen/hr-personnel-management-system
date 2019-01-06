package com.six.hrpms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SalaryRecord {
    private Integer id;

    private String userId;

    private Date startTime;

    private Date endTime;

    private Double salary;

    private Double workTime;

    private Double lateTime;

    private Double leaveEarlyTime;

    private Double businessTime;

    private Double businessMoney;

    private Double overtimeTime;

    private Double leaveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }

    public Double getLateTime() {
        return lateTime;
    }

    public void setLateTime(Double lateTime) {
        this.lateTime = lateTime;
    }

    public Double getLeaveEarlyTime() {
        return leaveEarlyTime;
    }

    public void setLeaveEarlyTime(Double leaveEarlyTime) {
        this.leaveEarlyTime = leaveEarlyTime;
    }

    public Double getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Double businessTime) {
        this.businessTime = businessTime;
    }

    public Double getBusinessMoney() {
        return businessMoney;
    }

    public void setBusinessMoney(Double businessMoney) {
        this.businessMoney = businessMoney;
    }

    public Double getOvertimeTime() {
        return overtimeTime;
    }

    public void setOvertimeTime(Double overtimeTime) {
        this.overtimeTime = overtimeTime;
    }

    public Double getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Double leaveTime) {
        this.leaveTime = leaveTime;
    }
}