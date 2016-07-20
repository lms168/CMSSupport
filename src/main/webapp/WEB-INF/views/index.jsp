<%--
  Created by IntelliJ IDEA.
  User: lms
  Date: 16-6-15
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <menus>
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
                  <li><a href="/static/dwz_jui/main.html" target="navTab" rel="main">我的主页</a></li>
                  <li><a href="/generate/toAdd" target="navTab" rel="generateCode">代码生成</a></li>
                  <li><a href="/user/page" target="navTab"  rel="customerList">用戶列表</a></li>
                  <li><a href="/test/page" target="navTab"  rel="testList">测试列表</a></li>
                  <li><a href="http://www.baidu.com" target="navTab" rel="page1">页面一(外部链接)</a></li>
                </ul>
              </li>
              <li><a href="/static/dwz_jui/dwz.frag.xml" target="navTab" external="true">dwz.frag.xml</a></li>
            </ul>
          </div>
          <!------------------------------------------菜单的结束---------------------------->





        </div>



      </div>



    </menus>
