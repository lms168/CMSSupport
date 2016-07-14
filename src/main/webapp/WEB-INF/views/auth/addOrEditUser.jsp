<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pageContent">
  <form method="post" action="/user/save?callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <input type="hidden" name="id" value="${user.id}">
      <p>
        <label>客 户 号：</label>
        <input name="username"  class="required"  type="text" size="30" value="${user.username}"/>
      </p>
      <p>
        <label>登录名：</label>
        <input name="loginName" class="required"  type="text" size="30" value="${user.loginName}" alt="请输入客户名称"/>
      </p>
      <p>
        <label>密码：</label>
        <input name="password" class="required"  type="text" size="30" value="${user.password}" alt="请输入密码"/>
      </p>
      <p>
        <label>是否锁定：</label>
        <select class="combox" name="locked">
          <option value=""  ${user.locked==null?"selected":""}>=全部=</option>
          <option value="true"  ${user.locked?"selected":""}>是</option>
          <option value="false" ${user.locked==true?"":"selected"}>否</option>
        </select>
      </p>
    </div>
    <div class="formBar">
      <ul>
        <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
