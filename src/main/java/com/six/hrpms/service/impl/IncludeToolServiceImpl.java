package com.six.hrpms.service.impl;

import com.six.hrpms.dao.IncludeToolMapper;
import com.six.hrpms.pojo.IncludeTool;
import com.six.hrpms.pojo.IncludeToolExample;
import com.six.hrpms.service.IncludeToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 作者：张彤
 * 时间：2017/8/1 16:18
 * 描述：收录工具的业务处理
 */
@Service("includeToolService")
public class IncludeToolServiceImpl implements IncludeToolService{

    @Autowired
    private IncludeToolMapper includeToolMapper;

    /**
     * 查询所有的收录工具
     * @return 返回所有的收录工具的集合
     */
    @Override
    public List<IncludeTool> findIncludeToolList() {
        //通过Criteria查询对象查询的四个步骤：

        //1.创建一个IncludeToolExample对象
        IncludeToolExample includeToolExample = new IncludeToolExample();
        //2.通过example类中的createCriteria()创建一个criteria对象
        IncludeToolExample.Criteria criteria = includeToolExample.createCriteria();
        //3.给criteria对象增加查询条件
        criteria.andIncludeToolIdIsNotNull();  //创建id列不为空的条件，即可表示查询所有的值
        //4.调selectByExample方法查询满足条件的结果集存放到集合中
        List<IncludeTool> includeToolList =  includeToolMapper.selectByExample(includeToolExample);

        return includeToolList;
    }

    /**
     * 更新收录工具
     * @param includeTool 收录工具对象
     */
    //此事物注解作用是当更新出现异常时就进行回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Override
    public void updateIncludeTool(IncludeTool includeTool) {
        //如果名称已存在直接抛出名称异常信息
        //此语句不能放到下边的try语句里，会被catch捕捉到异常信息，运行时异常的异常信息就会被覆盖掉
        if (includeTool.getIsEffective() == null){
            if (this.findIncludeToolNameIsExsitedUpdate(includeTool)){
                throw new RuntimeException("该收录工具已存在");
            }
        }
        try {
            includeToolMapper.updateByPrimaryKeySelective(includeTool); //updateByPrimaryKeySelective方法表示通过主键更新属性值不为null的列
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("更新数据异常");
        }
    }

    /**
     * 插入：校验插入的考核得分格式是否正确
     * @param validateScore 输入的收录工具名称
     * @return 返回true表示已存在，返回false表示不存在
     */
    @Override
    public boolean checkIncludeToolScoreInsert(Double validateScore){
        if(validateScore == null||validateScore < 0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 插入收录工具
     * @param includeTool 收录工具对象
     */
    //此事物注解作用是当更新出现异常时就进行回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Override
    public void insertIncludeTool(IncludeTool includeTool) {
        //如果名称已存在直接抛出名称异常信息
        //此语句不能放到下边的try语句里，会被catch捕捉到异常信息，运行时异常的异常信息就会被覆盖掉
        if(this.findIncludeToolNameIsExsitedInsert(includeTool.getIncludeToolName())){
            throw new RuntimeException("该收录工具已存在");
        }else if(!this.checkIncludeToolScoreInsert(includeTool.getScore())){
            throw new RuntimeException("格式错误");
        }
        try {
            includeToolMapper.insertSelective(includeTool);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入数据异常");
        }
    }

    /**
     * 更新：查询数据库是否存在同名的idenResultLevel
     * @param includeTool 收录工具对象
     * @return 返回true表示已存在，返回false表示不存在
     */
    @Override
    public boolean findIncludeToolNameIsExsitedUpdate(IncludeTool includeTool) {
        IncludeToolExample includeToolExample = new IncludeToolExample();
        IncludeToolExample.Criteria criteria = includeToolExample.createCriteria();
        if(includeTool.getIncludeToolName() != null){
            criteria.andIncludeToolNameEqualTo(includeTool.getIncludeToolName());
        }
        //排除自身
        if (includeTool.getIncludeToolId() != null){
            criteria.andIncludeToolIdNotEqualTo(includeTool.getIncludeToolId());
        }
        List<IncludeTool> includeToolList =  includeToolMapper.selectByExample(includeToolExample);

        //集合大于0表示查询到该记录，即数据库以存在
        if (includeToolList.size()>0){
            return true;
        }
        return false;
    }

    /**
     * 插入：查询数据库是否已存在同名的includeTool
     * @param validateName 输入的收录工具名称
     * @return 返回true表示已存在，返回false表示不存在
     */
    @Override
    public boolean findIncludeToolNameIsExsitedInsert(String validateName) {
        IncludeToolExample includeToolExample = new IncludeToolExample();
        IncludeToolExample.Criteria criteria = includeToolExample.createCriteria();
        if (validateName != null) {
            criteria.andIncludeToolNameEqualTo(validateName);
        }
        List<IncludeTool> includeToolList =  includeToolMapper.selectByExample(includeToolExample);

        //集合大于0表示查询到该记录，即数据库以存在
        if (includeToolList.size()>0){
            return true;
        }
        return false;
    }
}