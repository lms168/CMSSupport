<%--
  Created by IntelliJ IDEA.
  User: lms
  Date: 16-6-14
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>
    <sitemesh:write property='title' />
  </title>
  <sitemesh:write property='head' />
</head>
<body>
<header>header</header>
<hr />

hello.jsp的title将被填充到这儿：
<sitemesh:write property='title' /><br />
hello.jsp的body将被填充到这儿：
<sitemesh:write property='body' />
<hr />
hello.jsp的自定义标签将被填充到这儿：
<sitemesh:write property="myfooter"></sitemesh:write>
</body>
</html>