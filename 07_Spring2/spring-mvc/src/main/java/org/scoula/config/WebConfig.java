package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
     * 기존 자바 웹 어플리케이션의 핵심 설정 파일
     * 서블릿 컨테이너가 웹 어플리캐이션을 실행할때 가장 먼저 읽는 파일
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑
    // "/" 모든 요청에 대한 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

    /*
    * DispatcherServlet이 매핑되지 않은 요청을 받았을 때
    * 기본적으로 404 not found를 클라이언트에게 반환함.
    * 이 설정을 추가하면 예외(nogandlerFoundException)을 던지도록 강제
    * */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("ThrowExceptionIfNoHandlerFound","true");
    }
}
