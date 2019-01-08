package com.six.hrpms.aop;

import com.six.hrpms.dao.UserInfoMapper;
import com.six.hrpms.pojo.User;
import com.six.hrpms.pojo.UserInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 权限拦截
 *
 * @author: xkk
 * @Date: 2019/1/6 21:41
 */
@Aspect
@Component
public class RoleAspect {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 拦截controller包下的所有带有Admin的方法
     * @param proceedingJoinPoint 被拦截方法的信息
     * @return 对应前端页面
     */
    @Around(value = "execution(* com.six.hrpms.controller..*Admin*.*(..))")
    public String RoleJudge(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        HttpSession session = (HttpSession) args[0];

        User user = (User) session.getAttribute("user");
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getUserId());
        String s = new String();
        if (userInfo.getIsAdministrator()==1){
            s = (String) proceedingJoinPoint.proceed();
        }else {
            return "permissionDenied";
        }

        return s;

    }

}
