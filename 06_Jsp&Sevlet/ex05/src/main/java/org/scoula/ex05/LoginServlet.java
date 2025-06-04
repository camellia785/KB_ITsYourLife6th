package org.scoula.ex05;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // userid랑 passwd 이용해서 login 가능하도록 구현
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}