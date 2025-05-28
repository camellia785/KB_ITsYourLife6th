package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "my", value= "/my")
public class Myservlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("서브릿 객체 생성시 초기화할 내용... 한번만 호출");
    }

    @Override
    public void destroy() {
        System.out.println("서블릿 객체 소멸시 초기화할 내용... 한번만 호출");
    }

    //post 요청시 자동호출
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post 요청됨");
    }

    //get 요청시 자동호출
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청됨");
    }
}
