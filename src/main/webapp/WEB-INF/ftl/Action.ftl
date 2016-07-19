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


   <#if opTypes?seq_contains("query")>
        /**
        *   分页查询
        */
        @RequestMapping("/page")
        public ModelAndView page${Bean}(${Bean} ${bean}) {
        BasePageVO basePageVO = this.getBaseConditionVo();
        Page<${Bean}> ${bean}Page = ${bean}Service.findAllDynatic(${bean},basePageVO.getPageable());
        mv.addObject("pageResult",${bean}Page);
        mv.setViewName("${pkg}/page${Bean}");
        return mv;
        }
   </#if>

    <#if opTypes?seq_contains("edit")||opTypes?seq_contains("add")>
        @RequestMapping("/find")
        public ModelAndView find${Bean}ById(${Bean} ${bean}){
            if (${bean}.getId()!=null){
                    ${bean} = ${bean}Service.find${Bean}ById(${bean}.getId());
            }
            mv.addObject("${bean}", ${bean});
            mv.setViewName("${pkg}/addOrEdit${Bean}");
            return mv;
        }

        /**
        *   增加
        */
        @RequestMapping("/save")
        public ModelAndView save${Bean}(${Bean} ${bean}){
            try {
                ${bean}Service.save${Bean}(${bean});
            }catch (Exception e){
               return ajaxDoneError("保存失败");
            }
            return ajaxDoneSuccess("保存成功");
        }
        </#if>




        <#if opTypes?seq_contains("delete")>
            /**
            *   删除
            */
            @RequestMapping("/delete")
            public ModelAndView delete${Bean}(${Bean} ${bean}){
                try{
                  ${bean}Service.delete${Bean}(${bean});
                }catch (Exception e){
                 return  ajaxDoneError("删除失败");
                }
                return ajaxDoneSuccess("删除成功");
            }
        </#if>

}
