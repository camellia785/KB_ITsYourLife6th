package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello World!";
        System.out.println("init() 호출됨 - 초기화완료");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() 호출됨 - 리소스 정리");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

}