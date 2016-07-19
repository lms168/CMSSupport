<%@page contentType="text/html;charset=UTF-8" language="java" %> <!--必须带上字符否则会出错-->
<%@ include file="../common/include.inc.jsp" %>
<div class="pageHeader">
  <pageHeader>
  <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/test/page" method="get">
    <div class="searchBar">
      <table class="searchContent">
        <tr>
            <td>
                    <label>名称</label>
                    <input type="text" name="name" value="${test.name}"/>
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
            <li><a class="delete" href="/test/delete?id={id}" rel="deleteTest" target="ajaxTodo"><span>确定要删除吗?</span></a></li>
            <li class="line">line</li>
    </ul>
  </div>
  <table class="table" width="100%" layoutH="138">
    <thead>
    <tr>
          <th>名称</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${result!=null}">
        <c:forEach items="${result}" var="item" varStatus="stauts">
                <tr target="id" rel="${item.id}">
                <td>${stauts.index+1}</td>
                <td>${item.name}</td>
          </tr>
        </c:forEach>
    </c:if>
    </tbody>
  </table>
  </pageContent>
</div>