<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pageContent">
  <form method="post" action="/test/save?callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <input type="hidden" name="id" value="test.id">
        <p>
            <label>名称</label>
              <input type="text" name="name" value="${test.name}"/>
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
