<%@page contentType="text/html;charset=UTF-8" language="java" %> <!--必须带上字符否则会出错-->
<%@ include file="../common/include.inc.jsp" %>
<div class="pageHeader">
  <pageHeader>
  <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${actionUrl}" method="get">
    <div class="searchBar">
      <table class="searchContent">
        <tr>
        <#list searchList as searchBean>
            <td>
                <#--第${searchBean_index+1}个用户-->
                    <label>${searchBean.labelName}</label>
                <#if searchBean.tagType="text">
                    <#--<#assign value=searchBean.value/>-->
                    <#--<input type="text" name="${searchBean.name}" value=${"\"$\{"+value+"}\""}/>-->
                    <input type="text" name="${searchBean.name}" value="${searchBean.value}"/>
                <#elseif searchBean.tagType="select">
                    <select class="combox" name="${searchBean.name}">
                    <option value="">=全部=</option>
                    <#assign imap=searchBean.selectOptions>  <!--变量-->
                    <#list imap?keys as key>
                        <option value="${key}" >${imap[key]}</option>
                    </#list>
                    </select>
                </#if>
            </td>
        </#list>
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
        <#list opBtnList as btn>
            <li><a class="${btn["class"]}" href="${btn["href"]}" rel="${btn["rel"]}" target="${btn["target"]}"><span>${btn["title"]}</span></a></li>
            <li class="line">line</li>
        </#list>
    </ul>
  </div>
  <table class="table" width="100%" layoutH="138">
    <thead>
    <tr>
      <#list tableColNames as col>
          <#--<th width="${col["width"]}">${col["name"]}</th>-->
          <th>${col["name"]}</th>
      </#list>
    </tr>
    </thead>
    <tbody>
    <c:if test="${r'${result!=null}'}">
        <c:forEach items="${r'${result}'}" var="item" varStatus="stauts">
            <#if showId??>
                <tr target="id" rel="${r'${item.id}'}">
            <#else >
                <tr>
            </#if>
               <#list tableColValues as colValue>
                <td>${colValue}</td>
               </#list>
               <#--<td>${r"${item.username}"}</td>-->
          </tr>
        </c:forEach>
    </c:if>
    </tbody>
  </table>
  </pageContent>
</div>