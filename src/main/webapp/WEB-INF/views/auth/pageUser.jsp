<%@page contentType="text/html;charset=UTF-8" language="java" %> <!--必须带上字符否则会出错-->
<%@ include file="../common/include.inc.jsp" %>


<div class="pageHeader">
  <pageHeader>
  <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/user/page" method="get">
    <div class="searchBar">
      <table class="searchContent">
        <tr>
          <td>
            <label>客户名：</label><input type="text" name="username" value="${user.username}" />
          </td>
          <td>
            <label>陆名：</label><input type="text" name="loginName" value="${user.loginName}"/>
          </td>
          <td>
            <label>是否锁定：</label>
            <select class="combox" name="locked">
              <option value=""  ${user.locked==null?"selected":""}>=全部=</option>
              <option value="true"  ${user.locked?"selected":""}>是</option>
              <option value="false" ${user.locked==true?"":"selected"}>否</option>
            </select>
          </td>
        </tr>
      </table>
      <div class="subBar">
        <ul>
          <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
          <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
        </ul>
      </div>
    </div>
  </form>
  </pageHeader>
</div>



<div class="pageContent">
  <pageContent>
  <div class="panelBar">
    <ul class="toolBar">
      <%--<shiro:hasRole name="admin">--%>
        <li><a class="add" href="<%=request.getContextPath()%>/user/findByCusId" rel="addOrEditCus" target="dialog"><span>添加</span></a></li>
        <li><a class="edit" href="<%=request.getContextPath()%>/user/findByCusId?id={userId}" rel="addOrEditCus"  target="dialog"><span>修改</span></a></li>
      <%--</shiro:hasRole>--%>
        <li><a class="delete" href="<%=request.getContextPath()%>/user/delete?id={userId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>

      <li class="line">line</li>
      <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
    </ul>
  </div>
  <table class="table" width="100%" layoutH="138">
    <thead>
    <tr>
      <th width="80">序号</th>
      <th width="120">用户号</th>
      <th width="100">登录名</th>
      <th width="150">状态</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${result!=null}">
        <c:forEach items="${result}" var="item" varStatus="stauts">
           <tr target="userId" rel="${item.id}">
                <td>${stauts.index+1}</td>
                <td>${item.username}</td>
                <td>${item.loginName}</td>
                <td>${item.locked}</td>
          </tr>
        </c:forEach>
    </c:if>
    </tbody>
  </table>
  </pageContent>
</div>