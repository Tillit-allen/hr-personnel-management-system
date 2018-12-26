package com.six.hrpms.controller;

import com.six.hrpms.pojo.IncludeTool;
import com.six.hrpms.service.IncludeToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * @author xuekeke
 */
@Controller
@RequestMapping("/")
public class IncludeToolController {

    @Autowired
    private IncludeToolService includeToolService;

    /**
     * 查询所有的收录工具
     * @param model 视图对象，通过model对象可以向前台传值，作用相当于request对象
     * @return 返回收录工具列表页面
     */
    @RequestMapping("toIncludeToolList.action")
    public String toIncludeToolList(Model model){
        //将收录工具集合传到前台
        model.addAttribute("includeToolList",includeToolService.findIncludeToolList());
        return "system/includeTool/includeToolList";
    }

    /**
     * 更新收录工具
     * @param includeTool 更新的收录工具对象，springMVC会根据input标签名自动对对象属性进行赋值
     * @param model 重定向视图对象，使用此对象在重定向中也能传值
     * @return 重定向到收录工具列表
     */
    @RequestMapping("updateIncludeTool.action")
    public String updateIncludeTool(IncludeTool includeTool, RedirectAttributesModelMap model){
        try {
            includeToolService.updateIncludeTool(includeTool);
        } catch (Exception e) {
            //异常处理，返回更新数据失败信息
            if (e.getMessage().equals("更新数据异常")) {
                model.addFlashAttribute("exceptionMessage","更新数据异常");
                return "redirect:toIncludeToolList.action";
            }else if(e.getMessage().equals("该收录工具已存在")) {
                model.addFlashAttribute("exceptionMessage","该收录工具已存在，更新失败");
                return "redirect:toIncludeToolList.action";
            }
        }
        return "redirect:toIncludeToolList.action";
    }

    /**
     * 插入收录工具
     * @param includeTool 收录工具对象，springMVC会根据input标签名自动对对象属性进行赋值
     * @param model 重定向视图对象，使用此对象在重定向中也能传值
     * @return 重定向到收录工具列表
     */
    @RequestMapping("insertIncludeTool.action")
    public String insertIncludeTool(IncludeTool includeTool, RedirectAttributesModelMap model){
        try {
            includeToolService.insertIncludeTool(includeTool);
        } catch (Exception e) {
            //异常处理，返回更新数据失败信息
            if (e.getMessage().equals("插入数据异常")) {
                model.addFlashAttribute("exceptionMessage","插入数据异常");
                return "redirect:toIncludeToolList.action";
            }else if (e.getMessage().equals("空")){
                model.addFlashAttribute("exceptionMessage","收录工具不能为空");
                return "redirect:toIncludeToolList.action";
            } else if(e.getMessage().equals("该收录工具已存在")) {
                model.addFlashAttribute("exceptionMessage","该收录工具已存在，插入失败");
                return "redirect:toIncludeToolList.action";
            }else if (e.getMessage().equals("格式错误")){
                model.addFlashAttribute("exceptionMessage","考核得分不能为空或负数");
                return "redirect:toIncludeToolList.action";
            }
        }
        return "redirect:toIncludeToolList.action";
    }

    /**
     * 判断收录工具的名称是否存在
     * @param validateName 输入的收录工具的名称
     * @return 返回true表示已存在，返回false表示不存在
     */
    @RequestMapping("includeToolNameIsExisted.action")
    @ResponseBody   //返回json格式的数据
    public boolean resultLevelNameIsExisted(String validateName){
        return includeToolService.findIncludeToolNameIsExsitedInsert(validateName);
    }
}
