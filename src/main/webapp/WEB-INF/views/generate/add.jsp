<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pageContent">
  <form method="post" action="/generate/doAdd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">

      <dl>
        <dt>类名：</dt>
        <dd>
          <input type="text" id="entityName" name="entityName">
        </dd>
      </dl>


      <dl>
        <dt>生成的功能：</dt>
        <dd>
          <input type="checkbox" name="opType" value="query">查询
          <input type="checkbox" name="opType" value="add">添加
          <input type="checkbox" name="opType" value="edit">修改
          <input type="checkbox" name="opType" value="delete">删除
        </dd>
      </dl>

      <dl>
        <dt>
          <a class="button" href="javascript:initTabelInfo();"><span>加载属性</span></a>
        </dt>
      </dl>
      <div class="divider"></div>
      <table class="list" width="100%" layoutH="138">
        <thead>
        <tr>
          <th width="50">序号</th>
          <th>字段名</th>
          <th>显示名</th>
          <th>是否是修改字段</th>
          <th>是否是搜索条件</th>
          <th>搜索匹配</th>
        </tr>
        </thead>
        <tbody id="generateBody">
        <%--<tr>--%>
        <%--<td><input type="hidden" name="propertiesBeans[0].index" value="0">1</td>--%>
        <%--<td><input type="text" name="propertiesBeans[0].fieldName" value="name" class="textInput"></td>--%>
        <%--<td><input type="text" name="propertiesBeans[0].labelName" class="textInput"></td>--%>
        <%--<td><select name="propertiesBeans[0].ifEditField">--%>
          <%--<option value="0">否</option>--%>
          <%--<option value="1">是</option>--%>
        <%--</select>--%>
        <%--</td>--%>
        <%--<td>--%>
          <%--<select name="propertiesBeans[0].ifSearchField">--%>
            <%--<option value="0">否</option>--%>
            <%--<option value="1">是</option>--%>
          <%--</select>--%>
        <%--</td>--%>
        <%--<td>--%>
          <%--<input type="text" name="propertiesBeans[0].searchMatch" class="textInput">--%>
        <%--</td>--%>
        <%--</tr>--%>
        </tbody>
      </table>
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
  <script type="application/javascript">

    function initColInfo(index,obj){
      var colInfoTemplate = "<tr> <td><input type=\"hidden\" name=\"propertiesBeans["+index+"].index\" value="+index+" >"+(index+1)+"</td>" +
              "<td><input type=\"text\"  name=\"propertiesBeans["+index+"].fieldName\" value="+obj.fieldName+"></td>" +
              "<td><input type=\"text\"  name=\"propertiesBeans["+index+"].labelName\"/></td>" +
              "<td><select  name=\"propertiesBeans["+index+"].ifEditField\">" +
              "            <option value=\"0\">否</option>" +
              "              <option value=\"1\">是</option>" +
              "            </select>\n" +
              "          </td>" +
              "          <td>" +
              "            <select  name=\"propertiesBeans["+index+"].ifSearchField\">" +
              "              <option value=\"0\">否</option>" +
              "              <option value=\"1\">是</option>" +
              "            </select>" +
              "          </td>" +
              "          <td><input type=\"text\" name=\"propertiesBeans["+index+"].searchMatch\"/></td></tr>"
      return colInfoTemplate;
    }

    function initTabelInfo(){



      var entityName = $("#entityName").val();
      var generateBody = $("#generateBody")
      generateBody.empty();
      $.ajax({

        type: "POST",

        url: "/generate/getTableInfo",

        data: "entityName="+entityName,

        dataType:"json",

        success: function(msg){
          $.each(msg, function (index, value) {
             var col = initColInfo(index,value)
//            alert(col)
              generateBody.append(col).initUI();
          });


        }

      });
    }
  </script>
</div>
