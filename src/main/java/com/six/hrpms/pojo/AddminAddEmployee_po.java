package com.six.hrpms.pojo;

public class AddminAddEmployee_po {
    private String id;
    private String name;
    private String sex;
    private String loginName;
    private String password;
    private String deptId;
    private String boss;
    private double  basemoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public double getBasemoney() {
        return basemoney;
    }

    public void setBasemoney(double basemoney) {
        this.basemoney = basemoney;
    }
}
