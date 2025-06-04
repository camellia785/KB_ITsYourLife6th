package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*.do")
public class UTF8Filter implements Filter {
    private String encoding; //null로 초기화!

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        if (encoding == null) {
            encoding= "UTF-8"; // 기본 인코딩 설정
        }
        System.out.println("필터객체 생성됨");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);

        ///
    }

    @Override
    public void destroy() {
        System.out.println("필터객체 소멸됨");
    }
}
