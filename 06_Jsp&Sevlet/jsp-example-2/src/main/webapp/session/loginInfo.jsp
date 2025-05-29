<%--
  Created by IntelliJ IDEA.
  User: yeon
  Date: 2025. 5. 29.
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    String sessionInfo = String.valueOf(request.getSession());
    String sessionID = String.valueOf(request.getSession().getId());
    System.out.println("sessionInfo = " + sessionInfo);
    System.out.println("sessionID = " + sessionID);

  %>
  
  <p>아이디 : <%= userId%></p>
  <p>비밀번호 : <%= password%></p>
  
  <p><a href="logout.jsp"></a></p>
  </body>
</html>
