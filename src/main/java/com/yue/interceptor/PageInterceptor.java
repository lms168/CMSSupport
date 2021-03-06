package com.yue.interceptor;

import com.yue.common.BasePageVO;
import com.yue.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by lms on 16-7-3.
 * 分页拦截，对所有的分页信息进行拦截处理，并且组装分页信息
 */
public class PageInterceptor implements WebRequestInterceptor{

    public void preHandle(WebRequest request) throws Exception {
            System.out.println("====================分页拦截========================");
            int pageNum = StringUtils.isEmpty(request.getParameter("pageNum"))?1:Integer.valueOf(request.getParameter("pageNum"));
            int pageSize = StringUtils.isEmpty(request.getParameter("pageSize"))?0:Integer.valueOf(request.getParameter("pageSize"));
            int totalCount = StringUtils.isEmpty(request.getParameter("totalCount"))?0:Integer.valueOf(request.getParameter("totalCount"));
            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");
            BasePageVO vo = new BasePageVO(pageNum,pageSize,totalCount,orderField,orderDirection);
            request.setAttribute("basePageVO",vo,WebRequest.SCOPE_REQUEST);
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        Page page = (Page) modelMap.get("pageResult");
        BasePageVO basePageVO = (BasePageVO) webRequest.getAttribute("basePageVO",WebRequest.SCOPE_REQUEST);
        if (basePageVO !=null){
            basePageVO.setTotalCount((int) page.getTotalElements());
            modelMap.addAttribute("result",page.getContent());
            modelMap.addAttribute("baseConditionVO", basePageVO);
        }

    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
