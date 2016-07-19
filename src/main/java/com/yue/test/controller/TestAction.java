package com.yue.test.controller;

import com.yue.test.bean.*;
import com.yue.test.service.TestService;
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
@RequestMapping("test")
public class TestAction extends BaseAction {
    @Autowired
    private TestService testService;


        /**
        *   分页查询
        */
        @RequestMapping("/page")
        public ModelAndView pageTest(Test test) {
        BasePageVO basePageVO = this.getBaseConditionVo();
        Page<Test> testPage = testService.findAllDynatic(test,basePageVO.getPageable());
        mv.addObject("pageResult",testPage);
        mv.setViewName("test/pageTest");
        return mv;
        }

        @RequestMapping("/find")
        public ModelAndView findTestById(Test test){
            if (test.getId()!=null){
                    test = testService.findTestById(test.getId());
            }
            mv.addObject("test", test);
            mv.setViewName("test/addOrEditTest");
            return mv;
        }

        /**
        *   增加
        */
        @RequestMapping("/save")
        public ModelAndView saveTest(Test test){
            try {
                testService.saveTest(test);
            }catch (Exception e){
               return ajaxDoneError("保存失败");
            }
            return ajaxDoneSuccess("保存成功");
        }




            /**
            *   删除
            */
            @RequestMapping("/delete")
            public ModelAndView deleteTest(Test test){
                try{
                  testService.deleteTest(test);
                }catch (Exception e){
                 return  ajaxDoneError("删除失败");
                }
                return ajaxDoneSuccess("删除成功");
            }

}
