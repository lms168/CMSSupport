<%@ include file="../common/include.inc.jsp" %>
<form id="pagerForm" method="post" action="/user/page">
  <%--<input type="hidden" name="status" value="${param.status}">--%>
  <%--<input type="hidden" name="keywords" value="${basePageVO.keywords}" />--%>
  <input type="hidden" name="pageNum" value="${basePageVO.pageNum}" />
  <input type="hidden" name="pageSize" value="${basePageVO.pageSize}" />
  <input type="hidden" name="orderField" value="${basePageVO.orderField}" />
</form>


<div class="pageHeader">
  <!--pageHeader装饰-->
  <sitemesh:write property='pageHeader' />
</div>






<div class="pageContent">
  <!--pageContent装饰-->
  <sitemesh:write property='pageContent' />



  <div class="panelBar">
    <div class="pages">
      <span>显示</span>
      <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
        <option value="20">20</option>
        <option value="50">50</option>
        <option value="100">100</option>
        <option value="200">200</option>
      </select>
      <span>条，共${basePageVO.totalCount}条</span>
    </div>
    <div class="pagination" targetType="navTab" totalCount="${basePageVO.totalCount}" numPerPage="${basePageVO.pageSize}" pageNumShown="10" currentPage="${basePageVO.pageNum}"></div>
  </div>
</div>