<%--
  Created by IntelliJ IDEA.
  User: lms
  Date: 16-6-15
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>简单实用国产jQuery UI框架 - DWZ富客户端框架(J-UI.com)</title>

  <link href="<%=request.getContextPath()%>/static/dwz_jui/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
  <link href="<%=request.getContextPath()%>/static/dwz_jui/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
  <link href="<%=request.getContextPath()%>/static/dwz_jui/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
  <link href="<%=request.getContextPath()%>/static/dwz_jui/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
  <!--[if IE]>
  <link href="<%=request.getContextPath()%>/static/dwz_jui/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
  <![endif]-->

  <!--[if lt IE 9]>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/speedup.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
  <!--[if gte IE 9]><!-->
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/jquery-2.1.4.min.js" type="text/javascript"></script>
  <!--<![endif]-->

  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/jquery.cookie.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/jquery.validate.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/jquery.bgiframe.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/xheditor/xheditor-1.2.2.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

  <!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/raphael.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/g.raphael.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/g.bar.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/g.line.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/g.pie.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/static/dwz_jui/chart/g.dot.js"></script>

  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.core.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.util.date.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.validate.method.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.barDrag.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.drag.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.tree.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.accordion.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.ui.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.theme.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.switchEnv.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.alertMsg.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.contextmenu.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.navTab.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.tab.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.resize.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.dialog.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.dialogDrag.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.sortDrag.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.cssTable.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.stable.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.taskBar.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.ajax.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.pagination.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.database.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.datepicker.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.effects.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.panel.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.checkbox.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.history.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.combox.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.print.js" type="text/javascript"></script>

  <!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换时下面dwz.regional.zh.js还需要引入)
  <script src="bin/dwz.min.js" type="text/javascript"></script>
  -->
  <script src="<%=request.getContextPath()%>/static/dwz_jui/js/dwz.regional.zh.js" type="text/javascript"></script>

  <script type="text/javascript">
    $(function () {
      DWZ.init("<%=request.getContextPath()%>/static/dwz_jui/dwz.frag.xml", {
        loginUrl: "<%=request.getContextPath()%>/static/dwz_jui/login_dialog.html", loginTitle: "登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
        statusCode: {ok: 200, error: 300, timeout: 301}, //【可选】
        pageInfo: {
          pageNum: "pageNum",
          numPerPage: "numPerPage",
          orderField: "orderField",
          orderDirection: "orderDirection"
        }, //【可选】
        keys: {statusCode: "statusCode", message: "message"}, //【可选】
        ui: {hideMode: 'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
        debug: false,	// 调试模式 【true|false】
        callback: function () {
          initEnv();
          $("#themeList").theme({themeBase: "themes"}); // themeBase 相对于index页面的主题base路径
        }
      });
    });
  </script>

  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6PYkS1eDz5pMnyfO0jvBNE0F"></script>
  <script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
</head>

<body>


<div id="layout">

  <div id="header">
    <div class="headerNav">
      <a class="logo" href="http://j-ui.com">标志</a>
      <ul class="nav">
        <li><a href="<%=request.getContextPath()%>/static/dwz_jui/changepwd.html" target="dialog" width="600">修改密码</a></li>
        <li><a href="<%=request.getContextPath()%>/static/dwz_jui/login.html">退出</a></li>
      </ul>
    </div>

    <!-- navMenu -->

  </div>



  <div id="leftside">
    <div id="sidebar_s">
      <div class="collapse">
        <div class="toggleCollapse">
          <div></div>
        </div>
      </div>
    </div>
    <div id="sidebar">
      <div class="toggleCollapse"><h2>主菜单</h2>
        <div>收缩</div>
      </div>

      <div class="accordion" fillSpace="sidebar">



        <!------------------------------------------菜单的开始---------------------------->
        <div class="accordionHeader">
          <h2><span>Folder</span>界面组件</h2>
        </div>

        <div class="accordionContent">
          <ul class="tree treeFolder">

            <!--嵌套层菜单-->
            <li><a href="#" target="navTab">主框架面板</a>
              <ul>
                <li><a href="<%=request.getContextPath()%>/static/dwz_jui/main.html" target="navTab" rel="main">我的主页</a></li>
                <li><a href="<%=request.getContextPath()%>/user/page" target="navTab"  rel="customerList">用戶列表</a></li>
                <li><a href="http://www.baidu.com" target="navTab" rel="page1">页面一(外部链接)</a></li>
              </ul>
            </li>


            <li><a href="<%=request.getContextPath()%>/static/dwz_jui/dwz.frag.xml" target="navTab" external="true">dwz.frag.xml</a></li>
          </ul>
        </div>
        <!------------------------------------------菜单的结束---------------------------->





      </div>
    </div>
  </div>



  <div id="container">
    <div id="navTab" class="tabsPage">
      <div class="tabsPageHeader">
        <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
          <ul class="navTab-tab">
            <li tabid="main" class="main"><a href="javascript:;"><span><span
                    class="home_icon">我的主页</span></span></a></li>
          </ul>
        </div>
        <div class="tabsLeft">left</div>
        <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
        <div class="tabsRight">right</div>
        <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
        <div class="tabsMore">more</div>
      </div>
      <ul class="tabsMoreList">
        <li><a href="javascript:;">我的主页</a></li>
      </ul>
      <div class="navTab-panel tabsPageContent layoutBox">
        <div class="page unitBox">

        </div>

      </div>
    </div>
  </div>











</div>



<div id="footer">Copyright &copy; 2016 lmsh</div>
</body>
</html>
