<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>로그인정보세션저장</h1>
<%
  String id = request.getParameter("userid");
  if (id == null) {
    response.sendRedirect("loginForm.html");
    // 새로운 요청이 시작됨. 이전 기록이 없는 상태에서
  } else {
    // 브라우저가 input 태그로 보낸 value는
    // 모두 서버에서는 Spring으로 인식함
    String pw = request.getParameter("password");

    // 세션이 유지되는 동안 일반적으로 id,name,nicename,tel로 설정하는 편
    // 실무에서는 pw를 세션으로 잡지 않음, 값은 다 object로 형변환되어 들어감
    session.setAttribute("userid", id);
    session.setAttribute("password", pw);

    System.out.println("안녕하세요" + id + "<br>");
    System.out.println("<a href='loginInfo.jsp'>정보보기</a>");
  }
%>
</body>
