package com.six.hrpms.pojo;

import java.util.Date;

public class UserInfo {
    private String userId;

    private String userName;

    private String sex;

    private String bossName;

    private Double basicSalary;

    private String marriage;

    private Date birthday;

    private String homePlace;

    private Integer basicWorkTime;

    private Date salaryTime;

    private Integer isAdministrator;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(String homePlace) {
        this.homePlace = homePlace == null ? null : homePlace.trim();
    }

    public Integer getBasicWorkTime() {
        return basicWorkTime;
    }

    public void setBasicWorkTime(Integer basicWorkTime) {
        this.basicWorkTime = basicWorkTime;
    }

    public Date getSalaryTime() {
        return salaryTime;
    }

    public void setSalaryTime(Date salaryTime) {
        this.salaryTime = salaryTime;
    }

    public Integer getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(Integer isAdministrator) {
        this.isAdministrator = isAdministrator;
    }
}