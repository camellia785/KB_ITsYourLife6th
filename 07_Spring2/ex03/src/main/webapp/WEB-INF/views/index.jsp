<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<hr>
컨트롤러부터 전달받은 name: ${name} <br>
컨트롤러부터 전달받은 age: ${age} <br>

<%--Expression(출력) Lanaguage (EL) : 속성 지정된것만 출력시 --%>
</body>
</html>