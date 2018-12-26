package com.six.hrpms.service;

import com.six.hrpms.pojo.IncludeTool;

import java.util.List;

public interface IncludeToolService {

    /**
     * 查询所有的收录工具
     * @return 返回所有的收录工具的集合
     */
    public List<IncludeTool> findIncludeToolList();

    /**
     * 更新收录工具
     * @param includeTool 收录工具对象
     */
    public void updateIncludeTool(IncludeTool includeTool);

    /**
     * 插入收录工具
     * @param includeTool 收录工具对象
     */
    public void insertIncludeTool(IncludeTool includeTool);

    /**
     * 更新：查询数据库是否存在同名的idenResultLevel
     * @param includeTool 收录工具对象
     * @return 返回true表示已存在，返回false表示不存在
     */
    public boolean findIncludeToolNameIsExsitedUpdate(IncludeTool includeTool);

    /**
     * 插入：查询数据库是否已存在同名的includeTool
     * @param validateName 输入的收录工具名称
     * @return 返回true表示已存在，返回false表示不存在
     */
    public boolean findIncludeToolNameIsExsitedInsert(String validateName);

    /**
     * 插入：校验插入的考核得分格式是否正确
     * @param validateScore 输入的收录工具名称
     * @return 返回true表示已存在，返回false表示不存在
     */
    public boolean checkIncludeToolScoreInsert(Double validateScore);
}
