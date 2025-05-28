package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name = "responseServlet", value = {"/response"})
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 실행");

        // 한글이 깨지지 않도록 인코딩 설정
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("ResponseServlet 요청 성공");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
