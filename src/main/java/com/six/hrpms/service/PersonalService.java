package com.six.hrpms.service;

import com.six.hrpms.pojo.UserInfo;

import java.util.List;

public interface PersonalService {

    /*
     *   获取所有员工信息
     *   @params:null
     *   @return:list<UserInfo>
     * */
    List<UserInfo> getAllUser();
    /*
    *   从员工表里按照员工id读数据
    *   @params:
    *   @return:老子懒得写了
    * */
    UserInfo selectFromUserInfo(UserInfo userInfo);

    /*
    *   人事部门添加员工
    *   @params:controller传过来的UserInfo类对象
    *   @return:影响条数
    * */
    int addEmplForAdmin(UserInfo userInfo);

    /*
    *   员工接手补全自己信息
    *   @params:Controller传过来的
    *   @return:同上
    * */
    int addEmplForEmpl(UserInfo userInfo);

    /*
    *   员工补全完了管理员核准通过
    *   @params:
    *   @return：都他妈同上
    * */
    int updateEmplForAdmin(UserInfo userInfo);
}
