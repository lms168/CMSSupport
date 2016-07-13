Spring V4.1.0+的版本在不支持Servlet3.0的应用服务器上跑时会报以下错误：
NoSuchMethodError: javax.servlet.http.HttpServletResponse.getStatus()I
比如说：tomcat 7以下的版本、jboss 4.2.3以下的版本