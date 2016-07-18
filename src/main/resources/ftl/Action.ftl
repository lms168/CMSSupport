package com.yue.${pkg}.controller;

import com.yue.${pkg}.bean.*;
import com.yue.${pkg}.service.${Bean}Service;
import com.yue.common.BaseAction;
import com.yue.common.BasePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lms on 16-6-20.
 */
@Controller
@Scope("prototype")
@RequestMapping("${bean}")
public class ${Bean}Action extends BaseAction {
    @Autowired
    private ${Bean}Service ${bean}Service;
    @RequestMapping("/page")
    public ModelAndView page${Bean}(${Bean} ${bean}) {
        BasePageVO basePageVO = this.getBaseConditionVo();
        Page<${Bean}> ${bean}Page = ${bean}Service.findAllDynatic(${bean},basePageVO.getPageable());
        mv.addObject("pageResult",${bean}Page);
        mv.setViewName("${pkg}/page${Bean}");
        return mv;
    }


    @RequestMapping("/find")
    public ModelAndView find${Bean}ById(${Bean} ${bean}){
        if (${bean}.getId()!=null){
                ${bean} = ${bean}Service.find${Bean}ById(${bean}.getId());
        }
        mv.addObject("${bean}", ${bean});
        mv.setViewName("${pkg}/addOrEdit${Bean}");
        return mv;
    }



    @RequestMapping("/save")
    public ModelAndView save${Bean}(${Bean} ${bean}){
        try {
            ${bean}Service.save${Bean}(${bean});
        }catch (Exception e){
           return ajaxDoneError("用户保存失败");
        }
        return ajaxDoneSuccess("用户保存成功");
    }


    @RequestMapping("/delete")
    public ModelAndView delete${Bean}(${Bean} ${bean}){
        try{
          ${bean}Service.delete${Bean}(${bean});
        }catch (Exception e){
         return  ajaxDoneError("删除用户失败");
        }
        return ajaxDoneSuccess("删除用户成功");
    }

}
