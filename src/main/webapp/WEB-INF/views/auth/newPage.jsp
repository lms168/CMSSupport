<%@page contentType="text/html;charset=UTF-8" language="java" %> <!--必须带上字符否则会出错-->
<%@ include file="../common/include.inc.jsp" %>
<div class="pageHeader">
  <pageHeader>
  <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/user/page" method="get">
    <div class="searchBar">
      <table class="searchContent">
        <tr>
            <td>
                    <input type="text" name="username" value="${user.username}"/>
            </td>
            <td>
                    <select class="combox" name="locked">
                    <option value="">=全部=</option>
                      <!--变量-->
                        <option value="true" >是</option>
                        <option value="false" >否</option>
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
            <li><a class="add" href="/user/find" rel="addOrEdit" target="dialog"><span>添加</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="/user/find?id={id}" rel="addOrEdit" target="dialog"><span>修改</span></a></li>
            <li class="line">line</li>
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
                <tr target="id" rel="${item.id}">
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