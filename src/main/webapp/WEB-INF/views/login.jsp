<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
  <meta http-equiv="Cache-Control" content="no-cache" />
  <link rel="Shortcut Icon" href="static/images/favicon.ico" type="image/x-icon"/>
  <script type="text/javascript" src="static/dwz_jui/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="static/dwz_jui/js/jquery.validate.min.js"></script>
  <title>掌众传媒广告运营综合平台-登录页</title>
  <style>
    body {font-size:12px; font-family:"宋体"; color:#333; background-color:White; }
    html, body { height:100%; }
    *{ padding:0px; margin:0px;}
    ul,li{ list-style-type:none; }
    a{ color:#0054A6; text-decoration:none; }
    a:hover{ color:#ff6600; text-decoration:underline; }

    .container{ width:100%;height:435px; background:url(static/images/bgline.png) repeat-x left center;padding-top:110px;  }
    .content{ width:745px;margin:0 auto;}
    .Llogo{ float:left;width:230px;}
    .Rlogin{ float:left;width:420px;padding:70px 40px 0 40px }
    .Rlogin{background:#5B72B0 url(static/images/robg.png) repeat-x top left; overflow:hidden;height:194px }
    .Rlogin p{ width:100%; padding-bottom:9px; float:left;}
    .Rlogin p label{ display:block; float:left; color:#fff;  padding-top:2px; text-align:right;font-size:14px;  }
    .ft12{font-size:12px;color:#fff;  padding:1px 0 0 2px;float:left;}
    .Rlogin p input{height:16px; padding:2px 0px 0px 3px;float:left; font-family:Tahoma;}
    .Rlogin p .textbox{ border:solid 1px #3958AC;  background:White url(static/images/ipt_bg.gif) repeat-x top left;   }

    .Rlogin a{ float:left; display:block; padding:6px 0px 0px 7px; color:#000f36; }
    .Rlogin a:hover{ color:#1E3570; }
    .Rlogin p img{ float:left; padding-left:3px; vertical-align:bottom;  }
    .btn{float:left; padding:0 0 0 60px; width:225px; }
    .btn input{ width:84px; height:32px;background:url(static/images/btn.jpg) no-repeat left top; border:0px; color:#091F6D; font-size:16px; font-weight:bold; float:left; }
    .copyright{height:76px; padding:20px 0 5px 0;font-family:Tahoma;color:#959595;text-align:center; clear:both; background:url(images/foot.png) no-repeat  center top}

  </style>

</head>
<body>
<div class="container">
  <div class="content">
    <form id="loginForm" action="/loginAuthc" method="post" onsubmit="return verifys();">
      <div class="Llogo"><img src="static/images/lobg.png" alt="" width="242" height="264" /></div>
      <div class="Rlogin">
        <p>
          <label id="message">${message}</label>
        </p>
        <p><label>账  号：</label><input type="text" id="loginName" name="loginName" class="required"/></p>
        <p><label>密  码：</label><input type="password" id="password" name="password" class="required" /></p>
        <p><label>验  证：</label><input type="text" id="validateCode" name="validateCode" class="required" /><img id="code" title="点击换一张" onclick="changeImage()" src="<%=request.getContextPath() %>/validateCode"  style="cursor: pointer;"/></p>
        <p><span class="btn"><input style="height: 32px" type="submit" value="登 录" /></span></p>
        <!--
        <div class="btn"><input type="submit" value="登 录" />
          </div>
          -->
      </div>
    </form>
  </div>

  <div class="copyright">All Right Reserved Copyright © 2010    掌众传媒版权所有 Tel:0755-33300085</div>
</div>
<script type="text/javascript">
  function verifys(){
    var username = $("#loginName").val();
    var password = $("#loginPwd").val();
    var code = $("#validateCode").val();
    if(username==""||password==""){
      $("#message").show().html("请输入账  号或密码！");
      return false;
    }
    if(code==""){
      $("#message").show().html("请输入验证码！");
      return false;
    }
    return true;
  }

  function changeImage()
  {
    var time = (new Date()).valueOf();
    document.getElementById("code").src="<%=request.getContextPath()%>/validateCode?time="+time;
  }
</script>

</body>
</html>



